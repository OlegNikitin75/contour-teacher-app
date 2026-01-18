package alex.dev.contourteacherapp.presentation.navigation

import alex.dev.contourteacherapp.data.model.UserProfileResponseDto
import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppStartupViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val supabase: SupabaseClient,
) : ViewModel() {
    private val _startState = MutableStateFlow<TeacherScreens>(TeacherScreens.Loading)
    val startState: StateFlow<TeacherScreens> = _startState.asStateFlow()

    init {
        determineStartDestination()
    }

    private fun determineStartDestination() {
        viewModelScope.launch {
            supabase.auth.loadFromStorage()
            Log.d("SupabaseAuth", "1. currentUserOrNull() вызван")
            val prefs = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
            Log.d("SupabaseAuth", "2. SharedPreferences получены")
            val isFirstLaunch = prefs.getBoolean("is_first_launch", true)
            Log.d("SupabaseAuth", "3. isFirstLaunch = $isFirstLaunch")
            val user = supabase.auth.currentUserOrNull()
            Log.d("SupabaseAuth", "4. user = $user")

            if (user != null) {
                Log.d(
                    "SupabaseAuth",
                    "5. Пользователь найден: id = ${user.id}, email = ${user.email}"
                )
            } else {
                Log.d("SupabaseAuth", "5. Пользователь НЕ найден (null)")
            }

            Log.d("SupabaseAuth", "6. Перед проверкой сессии")
            val session = supabase.auth.currentSessionOrNull()
            Log.d("SupabaseAuth", "7. session = $session")

            if (session != null) {
                Log.d("SupabaseAuth", "8. Сессия активна, expires at: ${session.expiresAt}")
                Log.d("SupabaseAuth", "9. Access token: ${session.accessToken.take(20)}...")
            } else {
                Log.d("SupabaseAuth", "8. Нет активной сессии")
            }

            Log.d("SupabaseAuth", "10. Перед определением состояния")

            _startState.value = when {
                isFirstLaunch -> {
                    Log.d("SupabaseAuth", "11. Первый запуск -> IntroScreen")
                    prefs.edit { putBoolean("is_first_launch", false) }
                    TeacherScreens.IntroScreen
                }

                user == null -> {
                    Log.d("SupabaseAuth", "12. Пользователь null -> SignInScreen")
                    TeacherScreens.SignInScreen
                }

                else -> {
                    Log.d("SupabaseAuth", "13. Проверка профиля для user: ${user.id}")
                    val profileDto = try {
                        supabase.from("user_profile")
                            .select {
                                filter {
                                    eq("id", user.id)
                                }
                                limit(1)
                            }
                            .decodeList<UserProfileResponseDto>()
                            .firstOrNull()
                    } catch (e: Exception) {
                        Log.e("SupabaseAuth", "14. Ошибка при получении профиля: ${e.message}")
                        null
                    }
                    val profile = profileDto?.toDomain()
                    Log.d("SupabaseAuth", "15. Профиль получен: $profile")


                    if (profile?.isProfileComplete == true) {
                        Log.d("SupabaseAuth", "16. Профиль неполный -> CompleteProfileScreen")
                        TeacherScreens.CompleteProfileScreen
                    } else {
                        Log.d("SupabaseAuth", "16. Профиль полный -> HomeGraph")
                        TeacherScreens.HomeGraph
                    }
                }
            }

            Log.d("SupabaseAuth", "17. Конец функции, состояние: ${_startState.value}")
        }
    }
}
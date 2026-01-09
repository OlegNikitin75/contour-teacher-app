package alex.dev.contourteacherapp.presentation.feature.auth

//import alex.dev.common.data.model.AuthState
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//class AuthViewModel : ViewModel() {
//    private val _userState = mutableStateOf<AuthState>(AuthState.Loading)
//    val userState: State<AuthState> = _userState
//    fun signUp(
//        context: Context,
//        userEmail: String,
//        userPassword: String
//    ) {
//        viewModelScope.launch {
//            try {
//
//
//
//            } catch (e: Exception) {
//            }
//        }
//    }
//}
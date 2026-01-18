package alex.dev.contourteacherapp.presentation.feature.auth.sign_in_screen

import alex.dev.contourteacherapp.domain.errors.AuthError
import alex.dev.contourteacherapp.domain.model.SignInState
import alex.dev.contourteacherapp.domain.usecase.SignInWithGoogleUseCase
import android.content.Context
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.GetCredentialException
import androidx.credentials.exceptions.NoCredentialException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.io.IOException
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase
) : ViewModel() {
    private val _signInState = MutableStateFlow<SignInState>(SignInState.Idle)
    val signInState: StateFlow<SignInState> = _signInState.asStateFlow()
    fun signInWithGoogle(context: Context) {
        viewModelScope.launch {
            _signInState.value = SignInState.Loading

            signInWithGoogleUseCase(context)
                .onSuccess {
                    _signInState.value = SignInState.Success
                }
                .onFailure { throwable ->
                    val error = when (throwable) {
                        is NoCredentialException ->
                            AuthError.Google.NoAvailableAccounts(throwable)

                        is GetCredentialCancellationException ->
                            AuthError.Google.Cancelled(throwable)

                        is GoogleIdTokenParsingException ->
                            AuthError.Google.Other(throwable)

                        is GetCredentialException ->
                            AuthError.Google.Other(throwable)
                        // Сетевые ошибки (до и после Supabase)
                        is IOException,
                            ->
                            AuthError.Supabase.Network(throwable)
                        // Ошибки от Supabase (HTTP 4xx/5xx)
                        is io.github.jan.supabase.exceptions.RestException -> {
                            when (throwable.statusCode) {
                                in 400..499 -> AuthError.Supabase.Rejected(throwable)
                                else -> AuthError.Supabase.Network(throwable) // или Unknown
                            }
                        }

                        else ->
                            AuthError.Unknown(throwable)
                    }
                    _signInState.value = SignInState.Error(error)
                }
        }
    }
}
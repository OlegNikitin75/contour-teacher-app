package alex.dev.contourteacherapp.domain.model

sealed class AuthState {
    object Loading : AuthState()
    data class Success(val message: String) : AuthState()
    data class Error(val message: String) : AuthState()
}
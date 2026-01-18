package alex.dev.contourteacherapp.domain.model

import alex.dev.contourteacherapp.domain.errors.AppError

sealed class SignInState {
    data object Idle : SignInState()
    data object Loading : SignInState()
    data object Success : SignInState()
    data class Error(val appError: AppError) : SignInState()
}
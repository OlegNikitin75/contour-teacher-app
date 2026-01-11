package alex.dev.contourteacherapp.presentation.feature.activation

import alex.dev.contourteacherapp.R
import alex.dev.contourteacherapp.domain.errors.AppError
import alex.dev.contourteacherapp.domain.usecase.VerifyInviteCodeUseCase
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivationViewModel @Inject constructor(
    private val useCase: VerifyInviteCodeUseCase,
    @param:ApplicationContext private val appContext: Context
) : ViewModel() {
    private val _state = MutableStateFlow<ActivationState>(ActivationState.Idle)
    val state: StateFlow<ActivationState> = _state.asStateFlow()
    fun verifyCode(code: String) {
        viewModelScope.launch {
            _state.value = ActivationState.Loading
            useCase(code).fold(
                onSuccess = { _state.value = ActivationState.Success },
                onFailure = { error ->
                    val userMessage = when (error) {
                        is AppError -> error.getUserMessage(appContext)
                        else -> error.message ?: appContext.getString(R.string.unknown_error_m)
                    }

                    _state.value = ActivationState.Error(userMessage)
                }
            )
        }
    }

    fun resetState() {
        _state.value = ActivationState.Idle
    }
}

sealed class ActivationState {
    data object Idle : ActivationState()
    data object Loading : ActivationState()
    data object Success : ActivationState()
    data class Error(val message: String) : ActivationState()
}
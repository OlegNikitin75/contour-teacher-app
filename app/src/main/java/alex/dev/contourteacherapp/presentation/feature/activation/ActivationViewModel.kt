package alex.dev.contourteacherapp.presentation.feature.activation

import alex.dev.contourteacherapp.domain.usecase.VerifyInviteCodeUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivationViewModel @Inject constructor(
    private val useCase: VerifyInviteCodeUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<ActivationState>(ActivationState.Idle)
    val state: StateFlow<ActivationState> = _state.asStateFlow()
    fun verifyCode(code: String) {

        viewModelScope.launch {
            _state.value = ActivationState.Loading
            useCase(code).fold(
                onSuccess = { _state.value = ActivationState.Success },
                onFailure = {
                    _state.value = ActivationState.Error(it.message ?: "Ошибка проверки кода")
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
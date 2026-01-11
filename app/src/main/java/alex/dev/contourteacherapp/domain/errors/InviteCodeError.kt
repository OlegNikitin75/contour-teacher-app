package alex.dev.contourteacherapp.domain.errors

import alex.dev.contourteacherapp.R
import androidx.annotation.StringRes

sealed class InviteCodeError(
    @param:StringRes
    override val userMessageResId: Int,
    override val message: String,
    override val cause: Throwable? = null
) : AppError(userMessageResId, message, cause) {
    class InvalidCode(override val cause: Throwable? = null) : InviteCodeError(
        userMessageResId = R.string.invalid_invite_code_error_m,
        message = "Invalid activation code",
        cause = cause
    )

    data class ProcessingFailed(
        override val cause: Throwable? = null
    ) : InviteCodeError(
        userMessageResId = R.string.failed_process_verify_error_m,
        message = "Failed to process activation code",
        cause = cause
    )
//    object CodeExpired : ActivationError(
//        userMessageResId = R.string.invite_code_expired_m,
//        message = "Activation code has expired"
//    )
//    object CodeAlreadyUsed : ActivationError(
//        userMessageResId = R.string.invite_code_already_used_m,
//        message = "Activation code was already used"
//    )
//    data class Unexpected(
//        override val cause: Throwable? = null
//    ) : ActivationError(
//        userMessageResId = R.string.unexpected_error_m,
//        message = "Unexpected error during activation",
//        cause = cause
//    )
}

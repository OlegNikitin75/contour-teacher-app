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
}

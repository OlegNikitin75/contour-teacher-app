package alex.dev.contourteacherapp.domain.errors

import alex.dev.contourteacherapp.R
import android.content.Context
import androidx.annotation.StringRes

sealed class AppError(
    @param:StringRes open val userMessageResId: Int,
    override val message: String,
    override val cause: Throwable? = null
) : Exception(message, cause) {

    fun getUserMessage(context: Context): String {
        return context.getString(userMessageResId)
    }

    sealed class Network(
        @StringRes userMessageResId: Int,
        message: String,
        cause: Throwable
    ) : AppError(userMessageResId, message, cause) {

        class Timeout(cause: Throwable) : Network(
            R.string.network_error_timeout_m,
            "Network timeout",
            cause
        )

        class NoConnection(cause: Throwable) : Network(
            R.string.network_error_connect_m,
            "No internet connection",
            cause
        )
    }


    class Server(
        @StringRes userMessageResId: Int,
        message: String,
        cause: Throwable? = null
    ) : AppError(userMessageResId, message, cause) {

        companion object {
            fun fromStatusCode(statusCode: Int, cause: Throwable? = null): Server =
                when (statusCode) {
//                    400 -> Server(R.string.server_bad_request_m, "Bad Request", cause)
//                    401 -> Server(R.string.server_unauthorized_m, "Unauthorized", cause)
//                    403 -> Server(R.string.server_forbidden_m, "Forbidden", cause)
                    404 -> Server(R.string.server_not_found_m, "Resource not found", cause)
                    500 -> Server(R.string.server_internal_error_m, "Internal server error", cause)
                    503 -> Server(R.string.server_service_unavailable_m, "Service unavailable", cause)
                    else -> Server(R.string.server_error_m, "HTTP $statusCode", cause)
                }
        }
    }
    class UserCancelled(
        @StringRes userMessageResId: Int,
        message: String,
        cause: Throwable? = null
    ) : AppError(userMessageResId, message, cause)





    // Другие категории ошибок
}
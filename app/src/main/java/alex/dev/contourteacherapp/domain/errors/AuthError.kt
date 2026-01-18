package alex.dev.contourteacherapp.domain.errors

import alex.dev.contourteacherapp.R
import androidx.annotation.StringRes

sealed class AuthError(
    @param:StringRes override val userMessageResId: Int,
    override val message: String,
    override val cause: Throwable? = null
) : AppError(userMessageResId, message, cause) {

    // Google Sign-In / Credential Manager ошибки (самые частые)
    sealed class Google(
        @StringRes userMessageResId: Int,
        message: String,
        cause: Throwable? = null
    ) : AuthError(userMessageResId, message, cause) {

        class NoAvailableAccounts(cause: Throwable? = null) : Google(
            R.string.no_google_accounts_error_m,
            "Нет доступных аккаунтов Google на устройстве",
            cause
        )

        class Cancelled(cause: Throwable? = null) : Google(
            R.string.cancelled_error_m,
            "Вход отменён пользователем",
            cause
        )

        // Всё остальное от Credential Manager и парсинга токена
        class Other(cause: Throwable? = null) : Google(
            R.string.failed_google_credential_error_m,
            "Ошибка получения данных Google",
            cause
        )
    }

    // Supabase ошибки после получения токена
    sealed class Supabase(
        @StringRes userMessageResId: Int,
        message: String,
        cause: Throwable? = null
    ) : AuthError(userMessageResId, message, cause) {

        class Network(cause: Throwable? = null) : Supabase(
            R.string.network_auth_error_m,
            "Нет подключения к интернету",
            cause
        )

        // InvalidCredentials, 401, 403 и другие ошибки авторизации от сервера
        class Rejected(cause: Throwable? = null) : Supabase(
            R.string.invalid_credential_error_m,
            "Ошибка проверки учётных данных",
            cause
        )
    }

    // Всё остальное
    class Unknown(cause: Throwable? = null) : AuthError(
        R.string.unknown_error_m,
        "Неизвестная ошибка входа",
        cause
    )
}
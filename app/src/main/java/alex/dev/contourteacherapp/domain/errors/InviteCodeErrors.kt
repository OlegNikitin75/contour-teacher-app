package alex.dev.contourteacherapp.domain.errors

sealed class InviteCodeError : Throwable() {
    class NotFound : InviteCodeError() {
        override val message: String = "Неверный код приглашения"
    }

    class Unexpected(override val cause: Throwable? = null) : InviteCodeError() {
        override val message: String = "Не удалось обработать приглашение. Попробуйте позже"
    }
}
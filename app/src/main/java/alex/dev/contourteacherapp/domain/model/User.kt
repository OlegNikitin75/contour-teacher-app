package alex.dev.contourteacherapp.domain.model

data class User(
    val id: String,
    val email: String,
    val isEmailVerified: Boolean = false
)

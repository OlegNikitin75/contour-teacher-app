package alex.dev.contourteacherapp.domain.model

data class UserProfile(
    val id: String,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val avatarUrl: String?,
    val position: String?,
    val department: String?,
    val role: String,
    val createdAt: String?,
    val updatedAt: String?
) {
    val fullName: String
        get() = listOfNotNull(lastName, firstName, middleName)
            .joinToString(" ")
}

package alex.dev.contourteacherapp.domain.model

data class UserProfile(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val middleName: String? = null,
    val avatarUrl: String? = null,
    val position: String? = null,
    val department: String? = null,
    val role: String,
    val createdAt: String? = null,
    val updatedAt: String? = null
) {
    val fullName: String
        get() = listOfNotNull(lastName, firstName, middleName).joinToString(" ")
    val isProfileComplete: Boolean
        get() = firstName.isNullOrBlank() &&
                middleName.isNullOrBlank() &&
                lastName.isNullOrBlank() &&
                position.isNullOrBlank()&&
                department.isNullOrBlank()
}
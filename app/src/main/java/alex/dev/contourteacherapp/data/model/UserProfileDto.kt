package alex.dev.contourteacherapp.data.model

import alex.dev.contourteacherapp.domain.model.UserProfile
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileRequestDto(
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("middle_name")
    val middleName: String? = null,
    @SerialName("position")
    val position: String? = null,
    @SerialName("department")
    val department: String? = null
)

@Serializable
data class UserProfileResponseDto(
    @SerialName("id")
    @Contextual
    val id: String,
    @SerialName("first_name")
    val firstName: String?,
    @SerialName("last_name")
    val lastName: String?,
    @SerialName("middle_name")
    val middleName: String?,
    @SerialName("avatar_url")
    val avatarUrl: String?,
    @SerialName("position")
    val position: String?,
    @SerialName("department")
    val department: String?,
    @SerialName("role")
    val role: String,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("updated_at")
    val updatedAt: String?
) {
    fun toDomain(): UserProfile = UserProfile(
        id = id.toString(),
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        avatarUrl = avatarUrl,
        position = position,
        department = department,
        role = role,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

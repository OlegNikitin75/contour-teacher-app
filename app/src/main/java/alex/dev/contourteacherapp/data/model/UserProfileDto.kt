package alex.dev.contourteacherapp.data.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

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
    val id: UUID,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("patronymic")
    val patronymic: String?,
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
)

package alex.dev.contourteacherapp.data.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UserRequestDto(
    @SerialName("id")
    @Contextual
    val id: UUID,
    @SerialName("email")
    val email: String,
    @SerialName("price")
    val password: String,
)

@Serializable
data class UserResponseDto(
    @SerialName("id")
    @Contextual
    val id: UUID,
    @SerialName("email")
    val email: String,
    @SerialName("email_confirmed_at")
    val emailConfirmedAt: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null
)
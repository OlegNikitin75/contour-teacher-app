package alex.dev.contourteacherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("id")
    val id: String,
    @SerialName("email")
    val email: String,
    @SerialName("price")
    val password: String,
)
package alex.dev.contourteacherapp.domain.repository

interface InviteCodeRepository {
    suspend fun checkCodeExists(code: String): Boolean
    suspend fun deleteCode(code: String): Boolean
}
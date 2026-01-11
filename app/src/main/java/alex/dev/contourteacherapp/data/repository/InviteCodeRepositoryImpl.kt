package alex.dev.contourteacherapp.data.repository

import alex.dev.contourteacherapp.data.model.InviteCodeDto
import alex.dev.contourteacherapp.domain.errors.AppError
import alex.dev.contourteacherapp.domain.repository.InviteCodeRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class InviteCodeRepositoryImpl @Inject constructor(
    private val supabaseService: SupabaseClient
) : InviteCodeRepository {
    override suspend fun checkCodeExists(code: String): Boolean {
        return try {
            val result = supabaseService.from("activation_code")
                .select {
                    filter { eq("code", code) }
                }
                .decodeList<InviteCodeDto>()
            result.isNotEmpty()
        } catch (e: Exception) {
            throw when (e) {
                is SocketTimeoutException -> AppError.Network.Timeout(e)
                is IOException -> AppError.Network.NoConnection(e)
                else -> AppError.Server.fromStatusCode(500, e)
            }
        }
    }

    override suspend fun deleteCode(code: String): Boolean {
        return try {
            supabaseService.from("activation_code")
                .delete {
                    filter { eq("code", code) }
                }
            true
        } catch (e: Exception) {
            throw when (e) {
                is SocketTimeoutException -> AppError.Network.Timeout(e)
                is IOException -> AppError.Network.NoConnection(e)
                else -> AppError.Server.fromStatusCode(500, e)
            }
        }
    }
}

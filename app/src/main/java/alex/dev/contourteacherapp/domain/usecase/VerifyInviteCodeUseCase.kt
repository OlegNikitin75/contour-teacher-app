package alex.dev.contourteacherapp.domain.usecase

import alex.dev.contourteacherapp.domain.errors.AppError
import alex.dev.contourteacherapp.domain.errors.InviteCodeError
import alex.dev.contourteacherapp.domain.repository.InviteCodeRepository
import javax.inject.Inject

class VerifyInviteCodeUseCase @Inject constructor(
    private val repository: InviteCodeRepository
) {

    suspend operator fun invoke(code: String): Result<Unit> {
        return try {
            val exists = repository.checkCodeExists(code)

            if (!exists) {
                return Result.failure(InviteCodeError.InvalidCode())
            }

            val success = repository.deleteCode(code)
            if (success) {
                Result.success(Unit)
            } else {
                Result.failure(InviteCodeError.ProcessingFailed())
            }

        } catch (e: AppError) {
            // Уже наша ошибка - просто прокидываем
            Result.failure(e)
        } catch (e: Exception) {
            // Любая другая ошибка
            Result.failure(InviteCodeError.ProcessingFailed(e))
        }
    }
}
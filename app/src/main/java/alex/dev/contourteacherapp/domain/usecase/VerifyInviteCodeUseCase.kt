package alex.dev.contourteacherapp.domain.usecase

import alex.dev.contourteacherapp.domain.repository.InviteCodeRepository
import javax.inject.Inject

class VerifyInviteCodeUseCase @Inject constructor(
    private val repository: InviteCodeRepository
) {

    suspend operator fun invoke(code: String): Result<Unit> {
        if (!repository.checkCodeExists(code)) {
            return Result.failure(Exception("Неверный код"))
        }
        val success = repository.deleteCode(code)
        return if (success) {
            Result.success(Unit)
        } else {
            Result.failure(Exception("Не удалось обработать код"))
        }
    }
}
package alex.dev.contourteacherapp.domain.usecase

import alex.dev.contourteacherapp.domain.repository.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<Unit> {
        return authRepository.signOut()
    }
}
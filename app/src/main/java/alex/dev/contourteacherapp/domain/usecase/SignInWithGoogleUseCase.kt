package alex.dev.contourteacherapp.domain.usecase

import alex.dev.contourteacherapp.domain.repository.AuthRepository
import android.content.Context
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(context: Context): Result<Unit> {
        return authRepository.signInWithGoogle(context)
    }
}
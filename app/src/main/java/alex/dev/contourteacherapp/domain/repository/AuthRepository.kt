package alex.dev.contourteacherapp.domain.repository

import android.content.Context

interface AuthRepository {
    suspend fun signInWithGoogle(context: Context): Result<Unit>
    suspend fun signOut(): Result<Unit>
}
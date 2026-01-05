package alex.dev.contourteacherapp.domain.repository

import io.github.jan.supabase.auth.user.UserInfo

interface AuthRepository {
    suspend fun signUp(email: String, password: String): Boolean
    suspend fun signIn(email: String, password: String): Result<UserInfo>
    suspend fun signOut(): Result<Unit>
    suspend fun getCurrentUser(): Result<UserInfo?>
    suspend fun isUserLoggedIn(): Boolean
}
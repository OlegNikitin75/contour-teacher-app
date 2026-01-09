package alex.dev.contourteacherapp.data.repository

import alex.dev.contourteacherapp.domain.repository.AuthRepository
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.builtin.Email
import javax.inject.Inject

//class AuthRepoImpl @Inject constructor(
//    private val auth: Auth
//) : AuthRepository {
//    override suspend fun signUp(email: String, password: String): Boolean {
//        return try {
//            auth.signUpWith(Email) {
//                this.email = email
//                this.password = password
//            }
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
////override suspend fun signIn(email: String, password: String): Result<UserInfo> {
////    return try {
////        supabaseClient.auth.signInWith(Email) {
////            this.email = email
////            this.password = password
////        }
////        val user = supabaseClient.auth.currentUserOrNull()
////        Result.success(user ?: throw Exception("User not found after sign in"))
////    } catch (e: Exception) {
////        Result.failure(e)
////    }
////}
////
////override suspend fun signOut(): Result<Unit> {
////    return try {
////        supabaseClient.auth.signOut()
////        Result.success(Unit)
////    } catch (e: Exception) {
////        Result.failure(e)
////    }
////}
////
////override suspend fun getCurrentUser(): Result<UserInfo?> {
////    return try {
////        Result.success(supabaseClient.auth.currentUserOrNull())
////    } catch (e: Exception) {
////        Result.failure(e)
////    }
////}
////
////override suspend fun isUserLoggedIn(): Boolean {
////    return supabaseClient.auth.currentUserOrNull() != null
////}
//}
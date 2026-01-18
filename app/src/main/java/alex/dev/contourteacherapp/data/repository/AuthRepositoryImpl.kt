package alex.dev.contourteacherapp.data.repository

import alex.dev.contourteacherapp.BuildConfig
import alex.dev.contourteacherapp.domain.repository.AuthRepository
import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.Google
import io.github.jan.supabase.auth.providers.builtin.IDToken
import java.security.MessageDigest
import java.util.UUID
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val supabase: SupabaseClient
) : AuthRepository {
    override suspend fun signInWithGoogle(context: Context): Result<Unit> = runCatching {
        val credentialManager = CredentialManager.create(context)
        val rawNonce = UUID.randomUUID().toString()
        val hashedNonce = rawNonce
            .toByteArray()
            .let { MessageDigest.getInstance("SHA-256").digest(it) }
            .joinToString("") { "%02x".format(it) }
        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(BuildConfig.WEB_CLIENT_ID)
            .setNonce(hashedNonce)
            .setAutoSelectEnabled(true)
            .build()
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()
        val result = credentialManager.getCredential(
            request = request,
            context = context
        )
        val credential = result.credential
        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
        val idToken = googleIdTokenCredential.idToken

        supabase.auth.signInWith(IDToken) {
            this.idToken = idToken
            provider = Google
            nonce = rawNonce
        }

    }

    override suspend fun signOut(): Result<Unit> = runCatching {
        supabase.auth.signOut()
    }
}
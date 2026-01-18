package alex.dev.contourteacherapp.di

import alex.dev.contourteacherapp.data.network.SupabaseClientProvider
import alex.dev.contourteacherapp.data.repository.AuthRepositoryImpl
import alex.dev.contourteacherapp.data.repository.InviteCodeRepositoryImpl
import alex.dev.contourteacherapp.domain.repository.AuthRepository
import alex.dev.contourteacherapp.domain.repository.InviteCodeRepository
import alex.dev.contourteacherapp.domain.usecase.SignInWithGoogleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppTeacherModule {
    //Предоставление supabase client
    @Provides
    @Singleton
    fun provideSupabaseClient(
        provider: SupabaseClientProvider
    ): SupabaseClient = provider.client

    @Provides
    @Singleton
    fun provideSupabaseDatabase(client: SupabaseClient): Postgrest {
        return client.postgrest
    }

    @Provides
    @Singleton
    fun provideSupabaseAuth(client: SupabaseClient): Auth {
        return client.auth
    }

    @Provides
    @Singleton
    fun provideSupabaseStorage(client: SupabaseClient): Storage {
        return client.storage
    }

    @Provides
    fun provideInviteCodeRepository(client: SupabaseClient): InviteCodeRepository =
        InviteCodeRepositoryImpl(client)

    @Provides
    fun provideAuthRepository(supabase: SupabaseClient): AuthRepository =
        AuthRepositoryImpl(supabase)

    @Provides
    fun provideSignInWithGoogleUseCase(repository: AuthRepository): SignInWithGoogleUseCase =
        SignInWithGoogleUseCase(repository)

}
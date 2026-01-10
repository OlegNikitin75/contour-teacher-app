package alex.dev.contourteacherapp.di

import alex.dev.contourteacherapp.data.network.SupabaseClientProvider
import alex.dev.contourteacherapp.data.repository.InviteCodeRepositoryImpl
import alex.dev.contourteacherapp.domain.repository.InviteCodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
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
    fun provideInviteCodeRepository(client: SupabaseClient): InviteCodeRepository =
        InviteCodeRepositoryImpl(client)

//    @Provides
//    @Singleton
//    fun provideAuthRepository(client: SupabaseClient): AuthRepository =
//        AuthRepoImpl(client)
//
//    @Provides
//    @Singleton
//    fun provideProfileRepository(client: SupabaseClient): ProfileRepository =
//        ProfileRepoImpl(client)
}
package com.blueland99.github_mvvm.di

import com.blueland99.github_mvvm.data.repository.UserRepositoryImpl
import com.blueland99.github_mvvm.data.source.remote.GitHubApiService
import com.blueland99.github_mvvm.data.source.remote.UserRemoteDataSource
import com.blueland99.github_mvvm.domain.repository.UserRepository
import com.blueland99.github_mvvm.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGitHubApiService(retrofit: Retrofit): GitHubApiService {
        return retrofit.create(GitHubApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRemoteDataSource(apiService: GitHubApiService): UserRemoteDataSource {
        return UserRemoteDataSource(apiService)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        remoteDataSource: UserRemoteDataSource
    ): UserRepository {
        return UserRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetUsersUseCase(userRepository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }
}

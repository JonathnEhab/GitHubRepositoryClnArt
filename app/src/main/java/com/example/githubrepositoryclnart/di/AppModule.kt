package com.example.githubrepositoryclnart.di

import com.example.domain.repository.IssuesRepository
import com.example.domain.repository.RepoDetailsRepository
import com.example.domain.repository.TrendingRepository
import com.example.domain.usecase.FetchIssuesUseCase
import com.example.domain.usecase.FetchRepositoryDetailsUseCase
import com.example.domain.usecase.FetchTrendingGithubUseCase
import com.example.presentation.util.DispatcherProvider
import com.example.presentation.util.StandardDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return StandardDispatcherProvider()
    }

    @Singleton
    @Provides
    fun provideFetchTrendingGithubUseCase(
        trendingRepository: TrendingRepository
    ): FetchTrendingGithubUseCase {
        return FetchTrendingGithubUseCase(trendingRepository)
    }

    @Singleton
    @Provides
    fun provideFetchRepositoryDetailsUseCase(
        repoDetailsRepository: RepoDetailsRepository
    ): FetchRepositoryDetailsUseCase {
        return FetchRepositoryDetailsUseCase(repoDetailsRepository)
    }

    @Singleton
    @Provides
    fun provideIssuesUseCase(
        issuesRepository: IssuesRepository
    ): FetchIssuesUseCase {
        return FetchIssuesUseCase(issuesRepository)
    }
}
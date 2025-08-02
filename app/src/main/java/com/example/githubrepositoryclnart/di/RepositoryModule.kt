package com.example.githubrepositoryclnart.di

import com.example.data.data_source.local.LocalDataSource
import com.example.data.data_source.remote.api_services.IssuesApi
import com.example.data.data_source.remote.api_services.RepoDetailsApi
import com.example.data.data_source.remote.api_services.TrendingGithubApi
import com.example.data.repository.IssuesRepositoryImpl
import com.example.data.repository.RepoDetailsRepositoryImp
import com.example.data.repository.TrendingRepositoryImp
import com.example.domain.repository.IssuesRepository
import com.example.domain.repository.RepoDetailsRepository
import com.example.domain.repository.TrendingRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideTrendingGithubRepository(
        trendingGithubApi: TrendingGithubApi,
        localDataSource: LocalDataSource
    ): TrendingRepository {
        return TrendingRepositoryImp(trendingGithubApi, localDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideRepoDetailsRepository(
        repoDetailsApi: RepoDetailsApi
    ): RepoDetailsRepository {
        return RepoDetailsRepositoryImp(repoDetailsApi)
    }

    @Provides
    @ViewModelScoped
    fun provideIssuesRepository(
        issuesApi: IssuesApi
    ): IssuesRepository {
        return IssuesRepositoryImpl(issuesApi)
    }
}

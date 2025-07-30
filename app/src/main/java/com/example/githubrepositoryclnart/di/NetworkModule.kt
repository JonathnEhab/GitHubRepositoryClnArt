package com.example.githubrepositoryclnart.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.data.data_source.remote.api_services.IssuesApi
import com.example.data.data_source.remote.api_services.RepoDetailsApi
import com.example.data.data_source.remote.api_services.TrendingGithubApi
import com.example.githubrepositoryclnart.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        @ApplicationContext context: Context
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(ChuckerInterceptor(context))
                    .build()
            )
            .build()
    }

    @ViewModelScoped
    @Provides
    fun provideTrendingRepositoriesApiService(retrofit: Retrofit): TrendingGithubApi {
        return retrofit.create(TrendingGithubApi::class.java)
    }

    @ViewModelScoped
    @Provides
    fun provideRepositoryDetailsApiService(retrofit: Retrofit): RepoDetailsApi {
        return retrofit.create(RepoDetailsApi::class.java)
    }

    @ViewModelScoped
    @Provides
    fun provideIssuesApiService(retrofit: Retrofit): IssuesApi {
        return retrofit.create(IssuesApi::class.java)
    }
}
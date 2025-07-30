package com.example.data.data_source.remote.api_services

import com.example.data.data_source.remote.dto.trending_repo.TrendingGithubDataModel
import retrofit2.Response
import retrofit2.http.GET

interface TrendingGithubApi {
    @GET("search/repositories?q=language")
    suspend fun fetchTrendingRepositories(): Response<TrendingGithubDataModel>
}
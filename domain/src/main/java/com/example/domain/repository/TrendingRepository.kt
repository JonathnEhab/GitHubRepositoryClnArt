package com.example.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface TrendingRepository {
    suspend fun fetchTrendingGithub(isForceFetch : Boolean)
    : Flow<PagingData>
}
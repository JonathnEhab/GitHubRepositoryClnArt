package com.example.presentation.screens.trending_screen.trending_item.preview

import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.model.TrendingGithubUiModel
import kotlinx.coroutines.flow.flowOf


val trendingGithubUiModelPreviewData = TrendingGithubUiModel(
    id = 12345,
    name = "john",
    avatar = "https://fakeurl.com/avatar.png",
    description = "This is a fake repository. This is a fake repository. This is a fake repository. This is a fake repository. This is a fake repository.",
    stars = 30,
    owner = "jonathanEhab"
)


@Composable
fun createFakeTrendingLazyPagingItemsUiModel(): LazyPagingItems<TrendingGithubUiModel> {
    val fakeTrendingGithubListUiModel= listOf(
        trendingGithubUiModelPreviewData,
        trendingGithubUiModelPreviewData
    )
    val flow = flowOf(PagingData.from(fakeTrendingGithubListUiModel))

    return flow.collectAsLazyPagingItems()
}
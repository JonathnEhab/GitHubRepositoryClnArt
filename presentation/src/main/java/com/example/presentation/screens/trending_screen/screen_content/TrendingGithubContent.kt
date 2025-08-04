package com.example.presentation.screens.trending_screen.screen_content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import com.example.presentation.model.TrendingGithubUiModel
import com.example.presentation.screens.trending_screen.tredning_github_lazy_column.TrendingGithubLazyColumn
import com.example.presentation.screens.trending_screen.trending_item.preview.createFakeTrendingLazyPagingItemsUiModel
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import com.example.presentation.theme.LightGreen

@ExperimentalMaterialApi
@Composable
fun TrendingGithubContent(
    trendingRepositoriesLazyPagingItems: LazyPagingItems<TrendingGithubUiModel>,
    onPulledToRefresh: (Boolean) -> Unit,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
    val refreshingState =
        rememberPullRefreshState(
            false,
            { onPulledToRefresh(true) })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(refreshingState)
    ){
        TrendingGithubLazyColumn(
            trendingGithubList = trendingRepositoriesLazyPagingItems
        ) { owner, repoName -> onItemClicked(owner, repoName) }
        PullRefreshIndicator(
            refreshing = false,
            state = refreshingState,
            modifier = Modifier.align( Alignment.TopCenter),
            contentColor = LightGreen
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview(showSystemUi = true)
fun PreviewSwipeRefreshCompose(modifier: Modifier = Modifier) {
    GitHubRepositoryClnArtTheme {
        TrendingGithubContent(
            trendingRepositoriesLazyPagingItems = createFakeTrendingLazyPagingItemsUiModel(),
            onPulledToRefresh = {}
        ) { _,_ ->}
    }

}
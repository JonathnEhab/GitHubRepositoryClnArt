package com.example.presentation.screens.trending_screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.background.Background
import com.example.presentation.common_components.app_bar.AppBar
import com.example.presentation.common_components.screen_error.ErrorSection
import com.example.presentation.common_components.shimmer.github_shimmer_item.trending.AnimateShimmerTrendingList
import com.example.presentation.screens.trending_screen.screen_content.TrendingGithubContent
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import com.example.presentation.util.Locators.TAG_STRING_TRENDING_APP_BAR_TITLE_LABEL

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrendingGithubScreen(
    trendingUiState: TrendingUiState,
    onPulledToRefresh: (Boolean) -> Unit,
    onRefreshButtonClick: () -> Unit,
    onItemClick: (owner: String, repoName: String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Background()

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AppBar(
                titleTag = TAG_STRING_TRENDING_APP_BAR_TITLE_LABEL,
                onBackArrowClicked = {}
            )
            when {
                trendingUiState.isLoading -> {
                    AnimateShimmerTrendingList()
                }
                trendingUiState.isError -> {
                    ErrorSection(
                        onRefreshButtonClicked = onRefreshButtonClick,
                        customErrorExceptionUiModel = trendingUiState.customErrorExceptionUiModel
                    )
                }
                else -> {
                    trendingUiState.trendingGithubPagingDataFlow?.let {
                        val trendingRepositoryLazyPagingItem = it.collectAsLazyPagingItems()
                        TrendingGithubContent(
                            trendingRepositoryLazyPagingItem,
                            onPulledToRefresh
                        ) { owner, repoName ->
                            onItemClick(owner, repoName)
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewTrendingGithubScreenLoading() {
    TrendingGithubScreen(
        trendingUiState = TrendingUiState(isLoading = true),
        onPulledToRefresh = {},
        onRefreshButtonClick = {},
        onItemClick = { _, _ -> }
    )
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewTrendingGithubScreen() {
    GitHubRepositoryClnArtTheme(darkTheme = false, dynamicColor = false)
    {
        TrendingGithubScreen(
            trendingUiState = TrendingUiState(
                isLoading = false,
                isError = true
            ), onPulledToRefresh = {},
            onRefreshButtonClick = {},
            onItemClick = { _, _ -> }
        )

    }
}
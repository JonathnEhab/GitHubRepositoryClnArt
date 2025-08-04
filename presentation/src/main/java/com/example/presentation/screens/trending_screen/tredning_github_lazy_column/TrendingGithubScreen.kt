package com.example.presentation.screens.trending_screen.tredning_github_lazy_column

import androidx.compose.runtime.Composable
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState


@Composable
fun TrendingGithubScreen(
    trendingUiState: TrendingUiState,
    onPulledToRefresh: (Boolean) -> Unit,
    onRefreshButtonClicked: () -> Unit,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
}
package com.example.presentation.screens.issues_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.common_components.app_bar.AppBar
import com.example.presentation.common_components.screen_error.ErrorSection
import com.example.presentation.common_components.shimmer.github_shimmer_item.trending.AnimateShimmerTrendingList
import com.example.presentation.screens.issues_screen.issues_content.IssuesContent
import com.example.presentation.screens.issues_screen.review.issuesUiModelPreviewData
import com.example.presentation.screens.issues_screen.ui_state.IssuesUiState
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import com.example.presentation.util.Locators.TAG_STRING_ISSUES_APP_BAR_TITLE_LABEL

@Composable
fun IssuesScreen(
    issueState: IssuesUiState,
    onRefreshList: ()-> Unit,
    onBackArrowClick:()-> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        AppBar (
            titleText = "Issues",
            titleTag = TAG_STRING_ISSUES_APP_BAR_TITLE_LABEL,
            onBackArrowClicked = {onBackArrowClick()}
        )
        when{
            issueState.isLoading ->{
                AnimateShimmerTrendingList()
            }
            issueState.issuesList != null ->{
                IssuesContent(issueState.issuesList, onPulledToRefresh = onRefreshList)
            }
            else ->{
                ErrorSection(
                    onRefreshButtonClicked = onRefreshList,
                    customErrorExceptionUiModel = issueState.customerErrorExceptionUiModel
                )
            }
        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun PreviewTrendingGithubScreen(){
    GitHubRepositoryClnArtTheme {
        IssuesScreen(
            issueState = IssuesUiState(listOf(issuesUiModelPreviewData)),
            onRefreshList = {},
            onBackArrowClick = {}
        )
    }
}
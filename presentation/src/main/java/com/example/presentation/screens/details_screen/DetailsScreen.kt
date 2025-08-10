package com.example.presentation.screens.details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.background.Background
import com.example.presentation.common_components.app_bar.AppBar
import com.example.presentation.common_components.screen_error.ErrorSection
import com.example.presentation.common_components.shimmer.details.AnimateShimmerDetails
import com.example.presentation.common_components.shimmer.details.ShimmerDetails
import com.example.presentation.common_components.shimmer.github_shimmer_item.trending.AnimateShimmerTrendingList
import com.example.presentation.screens.details_screen.content.DetailsContent
import com.example.presentation.screens.details_screen.preview.fakeRepositoryDetailsUiModel
import com.example.presentation.screens.details_screen.ui_state.RepositoryDetailsUiState
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import com.example.presentation.util.Locators.TAG_STRING_DETAILS_APP_BAR_TITLE_LABEL

@Composable
fun DetailsScreen(
    repositoryDetailsUiState: RepositoryDetailsUiState,
    onRefreshButtonClick: ()-> Unit,
    onShowIssuesClicked : ()-> Unit,
    onBackArrowClicked:() -> Unit
) {
    Background()
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        AppBar(
            titleText = "Details",
            titleTag = TAG_STRING_DETAILS_APP_BAR_TITLE_LABEL,
            onBackArrowClicked = {onBackArrowClicked()}
        )
        when{
            repositoryDetailsUiState.isLoading ->{
                AnimateShimmerDetails()
            }
            repositoryDetailsUiState.repositoryDetails != null ->{
                DetailsContent(repositoryDetailsUiState.repositoryDetails,
                    onShowIssuesClicked)
            }
            else ->{
                ErrorSection(
                    onRefreshButtonClicked = onRefreshButtonClick,
                    customErrorExceptionUiModel = repositoryDetailsUiState.customExceptionUiModel
                )
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun PreviewGithubRepositoryDerails(){
    GitHubRepositoryClnArtTheme {
        DetailsScreen(
            repositoryDetailsUiState = RepositoryDetailsUiState(
                repositoryDetails = fakeRepositoryDetailsUiModel
            ),
            onBackArrowClicked = {},
            onRefreshButtonClick = {},
            onShowIssuesClicked = {}
        )
    }

}
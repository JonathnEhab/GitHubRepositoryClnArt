package com.example.presentation.screens.issues_screen.issues_content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.presentation.model.IssuesUiModel
import com.example.presentation.screens.issues_screen.issues_lazy_column.IssuesLazyColumn
import com.example.presentation.theme.LightGreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IssuesContent(
    issuesList : List<IssuesUiModel>,
    onPulledToRefresh : () -> Unit
) {
    val refreshingState = rememberPullRefreshState(false,
        {onPulledToRefresh()})
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(refreshingState)

    ){
        IssuesLazyColumn(
            issuesList = issuesList
        )
        PullRefreshIndicator(
            refreshing = false,
            state = refreshingState,
            modifier = Modifier.align(Alignment.TopCenter),
            contentColor = LightGreen
        )
    }


}
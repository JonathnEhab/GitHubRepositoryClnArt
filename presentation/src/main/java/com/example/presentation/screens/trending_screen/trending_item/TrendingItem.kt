package com.example.presentation.screens.trending_screen.trending_item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.model.TrendingGithubUiModel

@Composable
fun TrendingItem(
    trendingGithubUiModel: TrendingGithubUiModel,
    index: Int,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                onItemClicked(trendingGithubUiModel.owner, trendingGithubUiModel.name)
            }
            .padding(top = 2.dp, bottom = 4.dp)
            .background(
                color =  MaterialTheme.colorScheme.primary
            )
    ) { }

}
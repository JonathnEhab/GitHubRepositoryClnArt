package com.example.presentation.screens.issues_screen.issues_lazy_column

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.presentation.model.IssuesUiModel
import com.example.presentation.screens.issues_screen.issues_item.IssuesItem
import com.example.presentation.util.Locators

@Composable
fun IssuesLazyColumn(issuesList: List<IssuesUiModel>) {
    LazyColumn(
        modifier = Modifier
            .testTag(Locators.TAG_STRING_ISSUES_LIST)
            .padding(horizontal = 8.dp)
            .padding(bottom = 2.dp)
            .padding(top = 5.dp)
    ) {
        itemsIndexed(items = issuesList){ index , issuesUiModel ->
            IssuesItem(
                index = index,
                issuesUiModel = issuesUiModel
            )
            Divider()
        }
    }
}
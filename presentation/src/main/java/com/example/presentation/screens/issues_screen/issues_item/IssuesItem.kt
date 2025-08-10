package com.example.presentation.screens.issues_screen.issues_item

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.model.IssuesUiModel
import com.example.presentation.screens.issues_screen.review.issuesUiModelPreviewData
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import com.example.presentation.util.Locators.TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL
import com.example.presentation.util.Locators.TAG_STRING_ISSUE_AUTHOR_LABEL
import com.example.presentation.util.Locators.TAG_STRING_ISSUE_IMAGE
import com.example.presentation.util.Locators.TAG_STRING_ISSUE_STATE_LABEL
import com.example.presentation.util.Locators.TAG_STRING_ISSUE_TITLE_LABEL

@SuppressLint("DefaultLocale")
@Composable
fun IssuesItem(
    issuesUiModel: IssuesUiModel,
    index : Int
) {
    val createAtAnnotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
            append("Created At : ")
        }
        append(issuesUiModel.date.substringAfter(":"))
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 4.dp)
            .background(color = Color.White)
            .clip(RoundedCornerShape(25.dp))

    ) {
        Image(
            imageVector = Icons.Default.Info,
            contentDescription = "",
            modifier = Modifier
                .testTag(
                    String.format(
                        TAG_STRING_ISSUE_IMAGE, index
                    )
                )
                .size(40.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(RoundedCornerShape(80.dp)),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.inversePrimary)
        )
        Column (modifier = Modifier.padding(10.dp)) {
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = issuesUiModel.title,
                    modifier = Modifier
                        .testTag(
                            String.format(
                                TAG_STRING_ISSUE_TITLE_LABEL, index
                            )
                        )
                        .padding(bottom = 6.dp)
                        .weight(4f),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = issuesUiModel.state.name,
                    modifier = Modifier
                        .testTag(String.format(
                            TAG_STRING_ISSUE_STATE_LABEL, index
                        ))
                        .padding(end = 5.dp),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium
                )

            }
            Text(
                text = issuesUiModel.author,
                modifier = Modifier
                    .testTag(
                        String.format(
                            TAG_STRING_ISSUE_AUTHOR_LABEL, index
                        )
                    )
                    .padding(bottom = 10.dp),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = createAtAnnotatedString,
                modifier = Modifier.testTag(
                    String.format(
                        TAG_STRING_EXPANDABLE_ITEM_DESC_LABEL, index
                    )
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TrendingItemPreview() {
    GitHubRepositoryClnArtTheme {
        IssuesItem(
            issuesUiModel = issuesUiModelPreviewData,
            index = 1,
        )
    }
}
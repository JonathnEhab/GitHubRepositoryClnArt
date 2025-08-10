package com.example.presentation.screens.details_screen.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.presentation.model.RepositoryDetailsUiModel
import com.example.presentation.screens.details_screen.preview.fakeRepositoryDetailsUiModel
import com.example.presentation.theme.GitHubRepositoryClnArtTheme
import com.example.presentation.util.Locators
import com.example.presentation.R

@Composable
fun DetailsContent(
    repositoryDetailsUiModel: RepositoryDetailsUiModel,
    onShowIssuesClick : ()-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = repositoryDetailsUiModel.avatar)
                    .apply {
                        crossfade(1000)
                    }
                    .build()
            ),
            contentDescription = null,
            modifier = Modifier
                .testTag(Locators.TAG_STRING_DETAILS_AVATAR_IMAGE)
                .size(150.dp)
                .clip(CircleShape)

        )

        Text(
            text = repositoryDetailsUiModel.name!!,
            modifier = Modifier
                .testTag(Locators.TAG_STRING_DETAILS_NAME_LABEL)
                .padding(top = 12.dp)
                .padding(bottom = 8.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium
        )
        Row (
            modifier = Modifier
                .wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = repositoryDetailsUiModel.stars!!,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_STARS_NUMBER_LABEL)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Yellow
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = repositoryDetailsUiModel.language!!,
                modifier = Modifier
                    .padding(end = 6.dp)
                    .testTag(Locators.TAG_STRING_DETAILS_LANGUAGE_LABEL),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge
            )
            Box(
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_CIRCLE_ICON)
                    .size(15.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color.Magenta)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = repositoryDetailsUiModel.forks!!,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_FORKS_NUMBER_LABEL)
                    .padding(end = 6.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Image(
                painter = painterResource(id = R.drawable.ic_fork),
                contentDescription = "fork icon",
                modifier = Modifier
                    .testTag(Locators.TAG_STRING_DETAILS_FORK_ICON)
                    .size(35.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = repositoryDetailsUiModel.description!!,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .fillMaxWidth(.8f)
                .testTag(Locators.TAG_STRING_DETAILS_DESC_LABEL),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
          modifier = Modifier
              .height(60.dp)
              .fillMaxWidth()
              .padding(horizontal = 18.dp)
              .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults
                .buttonColors(MaterialTheme.colorScheme.secondary),
            onClick = onShowIssuesClick
        ) {
            Text(
                text = "Show Issues",
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailsPreview() {
    GitHubRepositoryClnArtTheme {
        DetailsContent(
            repositoryDetailsUiModel = fakeRepositoryDetailsUiModel,
            onShowIssuesClick = {}
        )
    }
}
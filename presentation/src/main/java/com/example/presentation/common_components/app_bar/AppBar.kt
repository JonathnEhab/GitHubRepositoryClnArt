package com.example.presentation.common_components.app_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import androidx.compose.material.Divider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    titleText: String = stringResource(id = R.string.github_repository),
    textColor: Color = MaterialTheme.colorScheme.secondary,
    titleTextStyle: TextStyle = MaterialTheme.typography.titleLarge,
    titleFontWeight: FontWeight = FontWeight.Bold,
    titleTag: String = "",
    appBarBackgroundColor: Color = MaterialTheme.colorScheme.primary,
    onBackArrowClicked: () -> Unit,
) {
    TopAppBar(
        modifier = Modifier.background(appBarBackgroundColor),
        title = {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onBackArrowClicked() },
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary)

                )
                Text(
                    modifier = modifier
                        .testTag(titleTag)
                        .fillMaxWidth(),
                    text = titleText,
                    color = textColor,
                    fontWeight = titleFontWeight,
                    style = titleTextStyle,
                )


            }
        }
    )
    Divider()

}

@Preview(showBackground = true)
@Composable
fun PreviewAppBar() {
    AppBar(
        onBackArrowClicked = {}
    )
}
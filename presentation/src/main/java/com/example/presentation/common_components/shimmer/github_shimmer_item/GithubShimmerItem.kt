package com.example.presentation.common_components.shimmer.github_shimmer_item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GithubShimmerIem(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Spacer(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .width(10.dp)
        )
        Column(verticalArrangement = Arrangement.Center) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = .7f)
                        .background(brush)
                )

                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = .7f)
                        .background(brush)
                )
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Spacer(
                    modifier = Modifier
                        .height(14.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = .3f)
                        .background(brush)
                )
            Spacer(modifier = Modifier.padding(6.dp))
            Spacer(
                modifier = Modifier
                    .height(14.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = .6f)
                    .background(brush)
            )

        }
    }
    Divider()
}

@Preview(showBackground = true)
@Composable
fun ShimmerItemPreview() {
    GithubShimmerIem(
        brush = Brush.linearGradient(
            listOf(
                Color.LightGray.copy(alpha = .6f),
                Color.LightGray.copy(alpha = .2f),
                Color.LightGray.copy(alpha = .6f)
            )
        )
    )

}
package com.example.presentation.common_components.shimmer.github_shimmer_item.trending

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.example.presentation.common_components.shimmer.github_shimmer_item.GithubShimmerIem
import com.example.presentation.util.Locators.TAG_STRING_LOADING_SHIMMER_TRENDING_LIST

@Composable
fun AnimateShimmerTrendingList() {
    LazyColumn(
        modifier = Modifier.testTag(TAG_STRING_LOADING_SHIMMER_TRENDING_LIST)
    ) {
        items(count = 5){
            val ShimmerColor = listOf(
                Color.LightGray.copy(alpha = .6f),
                Color.LightGray.copy(alpha = .2f),
                Color.LightGray.copy(alpha = .6f)
            )
            val transition = rememberInfiniteTransition(label = "")

            val translateAnim = transition.animateFloat(
                initialValue = 0f,
                targetValue = 1000f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 700,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Reverse
                ),
               label = ""
            )

            val brush = Brush.linearGradient(
                colors = ShimmerColor,
                start = Offset.Zero,
                end = Offset(x = translateAnim.value, y = translateAnim.value)
            )
            GithubShimmerIem(brush = brush)

        }

    }
}
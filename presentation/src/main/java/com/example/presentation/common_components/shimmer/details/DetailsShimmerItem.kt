package com.example.presentation.common_components.shimmer.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerDetails(brush: Brush) {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(150.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(fraction = .6f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(brush)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(fraction = 0.5f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(30.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(brush)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(30.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(brush)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(30.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(brush)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(fraction = .7f)
                    .height(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush)

            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(fraction = .7f)
                    .height(60.dp)
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(brush)

            )
        }
    }
}
@Composable
@Preview(showBackground = true)
fun ShimmerItemPreview() {
    ShimmerDetails(
        brush = Brush.linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.6f),
                Color.LightGray.copy(alpha = 0.2f),
                Color.LightGray.copy(alpha = 0.6f),
            )
        )
    )
}
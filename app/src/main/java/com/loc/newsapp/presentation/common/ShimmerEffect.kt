package com.loc.newsapp.presentation.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.Dimens.MediumPadding1

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "Shimmer Transition")

    val alpha = transition.animateFloat(
        initialValue = 0.2f
        , targetValue = 1f
        , animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing), repeatMode = RepeatMode.Restart
        ), label = "Shimmer Alpha Animation"

    ).value
    this.background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)

@Composable
fun ArticleCardShimmerEffect(modifier: Modifier = Modifier) {
    Row() {
        Box(
            modifier = Modifier
                .shimmerEffect()
                .size(ArticleCardSize)
                .clip(
                    MaterialTheme.shapes.medium
                )

        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Box(
                modifier = Modifier
                    .shimmerEffect()
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = MediumPadding1)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .shimmerEffect()
                        .fillMaxWidth(0.25f)
                        .height(15.dp)
                        .padding(horizontal = MediumPadding1)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Box(
                    modifier = Modifier
                        .shimmerEffect()
                        .fillMaxWidth(0.25f)
                        .height(15.dp)
                        .padding(horizontal = MediumPadding1)
                )
            }
        }
    }
}


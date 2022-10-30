package com.jaseemakhtar.compose.shimmer

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import com.jaseemakhtar.compose.shimmer.theme.Grey500

fun Modifier.shimmer(
    color: Color = Grey500,
    shimmerGradient: ShimmerGradient = DefaultGradientStops(color)
): Modifier = composed {
    val infiniteTransition = rememberInfiniteTransition()

    val progress: Float by infiniteTransition.animateFloat(
        initialValue = -0.6f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 900,
                easing = LinearEasing
            )
        )
    )

    val paint: Paint = remember {
        Paint().apply {
            isAntiAlias = true
            style = PaintingStyle.Fill
            blendMode = BlendMode.SrcAtop
        }
    }

    val colorGradient: ShimmerGradient = remember {
        shimmerGradient
    }

    return@composed Shimmer(
        shimmerGradient = colorGradient,
        paint = paint,
        progress = progress
    )
}
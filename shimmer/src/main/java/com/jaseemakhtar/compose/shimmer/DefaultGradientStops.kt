package com.jaseemakhtar.compose.shimmer

import androidx.compose.ui.graphics.Color

class DefaultGradientStops(private val color: Color): ShimmerGradient {

    override fun getColorStops(): List<Color> = listOf(
        color.copy(alpha = 0.0f),
        color.copy(alpha = 0.18f),
        color.copy(alpha = 0.26f),
        color.copy(alpha = 0.18f),
        color.copy(alpha = 0.0f)
    )
}
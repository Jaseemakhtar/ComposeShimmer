package com.jaseemakhtar.compose.shimmer

import androidx.compose.ui.graphics.Color

interface ShimmerGradient {
    fun getColorStops(): List<Color>
}
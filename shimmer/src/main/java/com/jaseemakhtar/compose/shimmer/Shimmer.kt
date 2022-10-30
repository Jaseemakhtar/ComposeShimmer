package com.jaseemakhtar.compose.shimmer

import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.withSaveLayer
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

internal class Shimmer(
    private val shimmerGradient: ShimmerGradient,
    private val paint: Paint,
    private val progress: Float
) : DrawModifier, LayoutModifier {

    private var width = 0f
    private var height = 0f
    private var reflectionWidth = 0f

    override fun ContentDrawScope.draw() {
        drawIntoCanvas { canvas ->
            canvas.withSaveLayer(
                Rect(0f, 0f, width, height),
                paint
            ) {
                drawContent()

                val xPos = progress * width

                drawRect(
                    brush = Brush.linearGradient(
                        shimmerGradient.getColorStops(),
                        start = Offset(xPos, 0f),
                        end = Offset((xPos + reflectionWidth), 0f)
                    ),
                    blendMode = BlendMode.SrcAtop,
                    topLeft = Offset(xPos, 0f),
                    size = Size(reflectionWidth, height)
                )
            }
        }
    }

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        reflectionWidth = 106.dp.toPx()

        val placeables = measurable.measure(constraints)

        val w = placeables.width
        val h = placeables.height

        width = w.toFloat()
        height = h.toFloat()

        return layout(w, h) {
            placeables.placeRelative(0, 0)
        }
    }
}
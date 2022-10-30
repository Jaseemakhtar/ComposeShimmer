package com.jaseem.compose.shimmer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jaseem.compose.shimmer.ui.theme.Grey200
import com.jaseemakhtar.compose.shimmer.shimmer

@Composable
fun ShimmerItemsDemoScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .shimmer()
        ) {
            repeat(4) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .wrapContentSize()
                        .border(BorderStroke(1.dp, Grey200), RoundedCornerShape(6.dp))
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Grey200, CircleShape)
                    )

                    Spacer(Modifier.width(12.dp))

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(16.dp)
                            .background(Grey200, RoundedCornerShape(4.dp))
                    )
                }
            }
        }
    }
}
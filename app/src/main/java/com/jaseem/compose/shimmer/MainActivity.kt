package com.jaseem.compose.shimmer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jaseem.compose.shimmer.ui.theme.ComposeShimmerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeShimmerTheme {
                ShimmerItemsDemoScreen()
            }
        }
    }
}

@Preview
@Composable
fun ShimmerDemoPreview() {
    ShimmerItemsDemoScreen()
}

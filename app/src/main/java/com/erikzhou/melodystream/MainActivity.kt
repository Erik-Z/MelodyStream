package com.erikzhou.melodystream

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erikzhou.melodystream.presentation.HorizontalCarousel
import com.erikzhou.melodystream.presentation.Toolbar
import com.erikzhou.melodystream.ui.theme.MelodyStreamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MelodyStreamTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Column(){
                        Toolbar()
                        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4")

                        HorizontalCarousel(items = items)
                    }
                }
            }
        }
    }
}


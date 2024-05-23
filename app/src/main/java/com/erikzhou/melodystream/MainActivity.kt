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
import com.erikzhou.melodystream.models.CategoryModel
import com.erikzhou.melodystream.presentation.CategoryCarousel
import com.erikzhou.melodystream.presentation.Toolbar
import com.erikzhou.melodystream.ui.theme.MelodyStreamTheme
import com.erikzhou.melodystream.viewModels.CategoryViewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val categoryViewModel = CategoryViewModel()
        setContent {
            MelodyStreamTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Column(){
                        Toolbar()
                        CategoryCarousel(items = categoryViewModel.categories)
                    }
                }
            }
        }
    }
}


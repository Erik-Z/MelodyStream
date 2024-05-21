package com.erikzhou.melodystream.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erikzhou.melodystream.R

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = "Welcome back",
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.menu_icon),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoriesCarousel() {
    val categories = listOf("Category 1", "Category 2", "Category 3", "Category 4")

    val pagerState = rememberPagerState {
        categories.size
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        pageSpacing = 16.dp
    ) { page ->
        CategoryCard(category = categories[page])
    }
}

@Composable
fun CategoryCard(category: String) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )
        }
    }
}

@Composable
fun HorizontalCarousel(
    items: List<Any>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    itemSpacing: Dp = 16.dp
) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(itemSpacing)
    ) {
        items(items) { item ->
            // Replace with your custom item layout
            Text(text = item.toString())
        }
    }
}
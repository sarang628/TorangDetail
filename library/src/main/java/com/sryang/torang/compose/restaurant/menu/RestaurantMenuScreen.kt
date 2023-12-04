package com.sryang.torang.compose.restaurant.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.library.RatingBar
import com.sryang.library.pullrefresh.PullToRefreshLayout
import com.sryang.library.pullrefresh.PullToRefreshLayoutState
import com.sryang.library.pullrefresh.RefreshIndicatorState
import com.sryang.library.pullrefresh.rememberPullToRefreshState
import com.sryang.torang.data.restaurant.MenuData
import com.sryang.torang.data.restaurant.testMenuData
import com.sryang.torang.viewmodels.RestaurantMenuViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RestaurantMenuScreen(
    viewModel: RestaurantMenuViewModel = hiltViewModel(),
    restaurantId: Int
) {
    val coroutine = rememberCoroutineScope()
    LaunchedEffect(key1 = restaurantId, block = {
        viewModel.loadMenu(restaurantId)
    })
    val uiState by viewModel.uiState.collectAsState()
    RestaurantMenu(list = uiState, onRefresh = {
        coroutine.launch {
            viewModel.loadMenu(restaurantId)
            it.updateState(RefreshIndicatorState.Default)
        }
    })
}

@Composable
fun RestaurantMenu(
    list: List<MenuData>,
    onRefresh: (PullToRefreshLayoutState) -> Unit,
) {
    val state = rememberPullToRefreshState()
    PullToRefreshLayout(
        pullRefreshLayoutState = state,
        refreshThreshold = 70,
        modifier = Modifier.fillMaxSize(),
        onRefresh = {
            onRefresh.invoke(state)
        }) {
        LazyVerticalGrid(columns = GridCells.Fixed(1), content = {
            items(list.size) {
                var menu = list[it]
                MenuItem(menu = menu)
            }
        })
    }
}

@Composable
fun MenuItem(menu: MenuData) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp, top = 2.dp, bottom = 2.dp)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = menu.url,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Box(
            Modifier
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(5.dp))
                .padding(start = 8.dp, bottom = 8.dp)
                .background(Color(0x99000000))
        ) {
            Column(Modifier.padding(4.dp)) {
                RatingBar(rating = 3.0f)
                Text(
                    text = "${menu.menuName} (${menu.price})",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenuItem() {
    MenuItem(menu = testMenuData())
}

@Preview
@Composable
fun PreviewMenu() {
    RestaurantMenu(list = ArrayList(), onRefresh = {})
}
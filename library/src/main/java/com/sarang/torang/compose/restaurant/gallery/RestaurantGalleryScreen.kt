package com.sarang.torang.compose.restaurant.gallery

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.sryang.library.pullrefresh.PullToRefreshLayout
import com.sryang.library.pullrefresh.PullToRefreshLayoutState
import com.sryang.library.pullrefresh.RefreshIndicatorState
import com.sryang.library.pullrefresh.rememberPullToRefreshState
import com.sarang.torang.data.restaurant.RestaurantImage
import com.sarang.torang.data.restaurant.testRestaurantImage
import com.sarang.torang.viewmodels.RestaurantGalleryViewModel
import kotlinx.coroutines.launch


@Composable
fun RestaurantGalleryScreen(
    viewModel: RestaurantGalleryViewModel = hiltViewModel(),
    restaurantId: Int
) {
    val uiState by viewModel.uiState.collectAsState()
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = restaurantId, block = {
        viewModel.loadImage(restaurantId)
    })

    RestaurantGalleryScreen(list = uiState, onRefresh = {
        coroutine.launch {
            viewModel.loadImage(restaurantId)
            it.updateState(RefreshIndicatorState.Default)
        }

    })
}

@Composable
fun RestaurantGalleryScreen(
    list: List<RestaurantImage>,
    onRefresh: (PullToRefreshLayoutState) -> Unit
) {
    val state = rememberPullToRefreshState()
    PullToRefreshLayout(
        modifier = Modifier.fillMaxSize(),
        pullRefreshLayoutState = state,
        refreshThreshold = 70,
        onRefresh = {
            onRefresh.invoke(state)
        }
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(140.dp), content = {
            items(list.size) {
                AsyncImage(
                    modifier = Modifier.padding(1.dp),
                    model = list[it].url,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        })
    }
}

@Preview
@Composable
fun PreviewRestaurantGallery() {
    RestaurantGalleryScreen(
        list = arrayListOf(
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage(),
            testRestaurantImage()
        ), onRefresh = {}
    )
}
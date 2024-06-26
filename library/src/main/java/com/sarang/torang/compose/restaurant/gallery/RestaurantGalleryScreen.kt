package com.sarang.torang.compose.restaurant.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
    restaurantId: Int,
    image: (@Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit)? = null,
    onImage: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = restaurantId, block = {
        viewModel.loadImage(restaurantId)
    })

    RestaurantGalleryScreen(
        list = uiState, onRefresh = {
            coroutine.launch {
                viewModel.loadImage(restaurantId)
                it.updateState(RefreshIndicatorState.Default)
            }
        }, image = image,
        onImage = onImage,
        modifier = modifier
    )
}

@Composable
fun RestaurantGalleryScreen(
    list: List<RestaurantImage>,
    onRefresh: (PullToRefreshLayoutState) -> Unit,
    onImage: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
    image: (@Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit)? = null,
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
        LazyVerticalStaggeredGrid(
            modifier = modifier.fillMaxSize(),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            columns = StaggeredGridCells.Adaptive(200.dp), content = {
                items(list.size) {
                    image?.invoke(
                        Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                            .clickable {
                                onImage.invoke(list[it].id)
                            },
                        list[it].url,
                        null,
                        null,
                        ContentScale.Crop
                    )
                }
            })
    }
}

@Preview
@Composable
fun PreviewRestaurantGallery() {
    RestaurantGalleryScreen(/*Preview*/
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
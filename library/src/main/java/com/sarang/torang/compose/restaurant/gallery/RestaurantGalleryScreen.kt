package com.sarang.torang.compose.restaurant.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sarang.torang.data.restaurant.RestaurantImage
import com.sarang.torang.data.restaurant.testRestaurantImage
import com.sarang.torang.viewmodels.RestaurantGalleryViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantGalleryScreen(
    modifier: Modifier = Modifier,
    viewModel: RestaurantGalleryViewModel = hiltViewModel(),
    restaurantId: Int,
    image: (@Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit)? = null,
    onImage: (Int) -> Unit = {},
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit), contents: @Composable (() -> Unit)) -> Unit = { _, _, _ -> }
) {
    val uiState = viewModel.uiState
    val coroutine = rememberCoroutineScope()
    val state = rememberPullToRefreshState()

    LaunchedEffect(key1 = restaurantId, block = {
        viewModel.loadImage(restaurantId)
    })

    _RestaurantGalleryScreen(
        list = uiState, onRefresh = {
            coroutine.launch {
                viewModel.loadImage(restaurantId)
                //state.updateState(RefreshIndicatorState.Default)
            }
        }, image = image,
        onImage = onImage,
        pullToRefreshLayout = pullToRefreshLayout
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun _RestaurantGalleryScreen(
    list: List<RestaurantImage>,
    onRefresh: () -> Unit,
    onImage: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
    image: (@Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit)? = null,
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit), contents: @Composable (() -> Unit)) -> Unit = { _, _, _ -> }
) {
    pullToRefreshLayout.invoke(
        false,
        { onRefresh.invoke() },
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
    _RestaurantGalleryScreen(/*Preview*/
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
package com.sarang.torang.compose.restaurant.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sarang.torang.data.restaurant.RestaurantImage
import com.sarang.torang.viewmodels.RestaurantGalleryViewModel

@Composable
fun RestaurantImages_(
    viewModel: RestaurantGalleryViewModel = hiltViewModel(),
    restaurantId : Int,
    onImage: ((Int) -> Unit)? = null,
    image: @Composable ((Modifier, String, Dp?, Dp?, ContentScale?, ) -> Unit)? = null,
) {
    val uiState = viewModel.uiState
    LaunchedEffect(restaurantId) {
        viewModel.loadImage(restaurantId)
    }
    if (uiState.isNotEmpty()) {
        LazyRow(Modifier.height(150.dp).fillMaxWidth()) {
            items(uiState.size, itemContent = {
                image?.invoke(Modifier.height(150.dp).width(150.dp).clickable { onImage?.invoke(uiState[it].id) }, uiState[it].url, 30.dp, 30.dp, ContentScale.Crop)
                Spacer(modifier = Modifier.width(8.dp))
            })
        }
    }
}

@Composable
fun RestaurantImages(
    list: List<RestaurantImage>? = null,
    onImage: ((Int) -> Unit)? = null,
    image: @Composable ((Modifier, String, Dp?, Dp?, ContentScale?, ) -> Unit)? = null,
) {
    if (!list.isNullOrEmpty()) {
        LazyRow(Modifier.height(150.dp).fillMaxWidth()) {
            items(list.size, itemContent = {
                image?.invoke(Modifier.height(150.dp).width(150.dp).clickable { onImage?.invoke(list[it].id) }, list[it].url, 30.dp, 30.dp, ContentScale.Crop)
                Spacer(modifier = Modifier.width(8.dp))
            })
        }
    }
}

@Preview
@Composable
fun PreviewRestaurantImages() {
    RestaurantImages(ArrayList<RestaurantImage>().apply {
        add(RestaurantImage(id = 0, url = "http://sarang628.iptime.org:89/restaurants/2.jpeg"))
        add(RestaurantImage(id = 1, url = "http://sarang628.iptime.org:89/restaurants/2-1.jpeg"))
        add(RestaurantImage(id = 2, url = "http://sarang628.iptime.org:89/restaurants/1.jpeg"))
        add(RestaurantImage(id = 3, url = "http://sarang628.iptime.org:89/restaurants/1-1.jpeg"))
    })
}

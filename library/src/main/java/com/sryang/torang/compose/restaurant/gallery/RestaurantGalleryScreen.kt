package com.sryang.torang.compose.restaurant.gallery

import TorangAsyncImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.sryang.torang.data.restaurant.RestaurantImage
import com.sryang.torang.data.restaurant.testRestaurantImage
import com.sryang.torang.viewmodels.RestaurantGalleryViewModel


@Composable
fun RestaurantGallery(
    viewModel: RestaurantGalleryViewModel = hiltViewModel(),
    restaurantId: Int,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = restaurantId, block = {
        viewModel.loadImage(restaurantId)
    })

    Column(
        Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(140.dp), content = {
            items(uiState.size) {
                AsyncImage(
                    modifier = Modifier.padding(1.dp),
                    model = uiState[it].url,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        })
    }
}

@Composable
fun RestaurantGallery(
    list: List<RestaurantImage>,
    reviewImageUrl: String
) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(140.dp), content = {
            items(list.size) {
                TorangAsyncImage(
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxSize(),
                    model = reviewImageUrl + list[it].url,
                    //contentDescription = "",
                    //contentScale = ContentScale.Crop
                )
            }
        })
    }
}

@Preview
@Composable
fun PreviewRestaurantGallery() {
    RestaurantGallery(
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
        ), reviewImageUrl = ""
    )
}
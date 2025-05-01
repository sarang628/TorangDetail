package com.sarang.torang.compose.restaurant

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.sarang.torang.data.restaurant.Feed
import com.sarang.torang.viewmodels.RestaurantFeedsViewModel

@Composable
fun RestaurantFeeds(
    restaurantId: Int,
    viewModel: RestaurantFeedsViewModel = hiltViewModel(),
    feed: @Composable (Feed) -> Unit = {}
) {

    val uiState = viewModel.uiState

    LaunchedEffect(restaurantId) {
        viewModel.fetch(restaurantId)
    }

    Column {
        //if (uiState.isNotEmpty()) {
            for (i in 0 until uiState.size) {
                feed.invoke(uiState[i])
            }
        //}
    }
}
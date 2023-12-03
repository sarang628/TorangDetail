package com.sryang.torang.usecase

import com.sryang.torang.data.restaurant.Feed
import com.sryang.torang.uistate.RestaurantInfoUIState


interface RestaurantInfoService {
    suspend fun loadRestaurant(restaurantId: Int): RestaurantInfoUIState

    suspend fun loadReviews(restaurantId: Int) : List<Feed>
}
package com.sarang.torang.usecase

import com.sarang.torang.data.restaurant.Feed
import com.sarang.torang.uistate.RestaurantInfoUIState


interface RestaurantInfoService {
    suspend fun loadRestaurant(restaurantId: Int): RestaurantInfoUIState

    suspend fun loadReviews(restaurantId: Int) : List<Feed>
}
package com.sr.restaurant.restaurant.usecase

import com.sr.restaurant.restaurant.data.FeedData
import com.sr.restaurant.restaurant.viewmodel.RestaurantInfoUIState

interface RestaurantInfoService {
    suspend fun loadRestaurant(restaurantId: Int): RestaurantInfoUIState

    suspend fun loadReviews(restaurantId: Int) : List<FeedData>
}
package com.sarang.torang.usecase

import com.sarang.torang.data.restaurant.RestaurantInfoData

interface FetchRestaurantUseCase {
    suspend fun invoke(restaurantId: Int): RestaurantInfoData
}
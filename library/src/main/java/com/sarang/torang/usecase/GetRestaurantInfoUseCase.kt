package com.sarang.torang.usecase

import com.sarang.torang.data.restaurant.RestaurantInfo

interface GetRestaurantInfoUseCase {
    suspend fun invoke(restaurantId: Int) : RestaurantInfo
}
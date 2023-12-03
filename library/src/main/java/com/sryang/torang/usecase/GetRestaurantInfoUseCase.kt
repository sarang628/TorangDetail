package com.sryang.torang.usecase

import com.sryang.torang.data.restaurant.RestaurantInfo

interface GetRestaurantInfoUseCase {
    suspend fun invoke(restaurantId: Int) : RestaurantInfo
}
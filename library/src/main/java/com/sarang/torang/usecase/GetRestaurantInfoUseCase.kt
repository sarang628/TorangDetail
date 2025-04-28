package com.sarang.torang.usecase

import com.sarang.torang.data.restaurant.RestaurantInfoData

interface GetRestaurantInfoUseCase {
    suspend fun invoke(restaurantId: Int) : RestaurantInfoData
}
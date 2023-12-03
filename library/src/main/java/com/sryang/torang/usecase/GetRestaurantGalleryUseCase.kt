package com.sryang.torang.usecase

import com.sryang.torang.data.restaurant.RestaurantImage

interface GetRestaurantGalleryUseCase {
    suspend fun invoke(restaurantId : Int): List<RestaurantImage>
}
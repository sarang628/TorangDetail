package com.sarang.torang.usecase

import com.sarang.torang.data.restaurant.RestaurantImage

interface GetRestaurantGalleryUseCase {
    suspend fun invoke(restaurantId : Int): List<RestaurantImage>
}
package com.sarang.torang.usecase

import com.sarang.torang.data.restaurant.Feed

interface FetchReviewsUseCase {
    suspend fun invoke(restaurantId: Int) : List<Feed>
}
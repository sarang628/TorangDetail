package com.sarang.torang.usecase

import com.sarang.torang.data.restaurant.MenuData

interface GetMenuUseCase {
    suspend fun invoke(restaurantId: Int): List<MenuData>
}
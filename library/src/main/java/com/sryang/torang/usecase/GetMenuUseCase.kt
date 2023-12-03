package com.sryang.torang.usecase

import com.sryang.torang.data.restaurant.MenuData

interface GetMenuUseCase {
    suspend fun invoke(restaurantId: Int): List<MenuData>
}
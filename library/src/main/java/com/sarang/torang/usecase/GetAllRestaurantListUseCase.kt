package com.sarang.torang.usecase

interface GetAllRestaurantListUseCase {
    suspend fun invoke(): List<String>
}
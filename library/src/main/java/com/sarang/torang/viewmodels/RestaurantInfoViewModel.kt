package com.sarang.torang.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sarang.torang.data.restaurant.RestaurantInfoData
import com.sarang.torang.usecase.FetchRestaurantUseCase
import com.sarang.torang.usecase.GetRestaurantInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantInfoViewModel @Inject constructor(
    private val fetchRestaurantUseCase: FetchRestaurantUseCase,
    private val getRestaurantInfoUseCase: GetRestaurantInfoUseCase
) :
    ViewModel() {
    val tag = "__RestaurantInfoViewModel"
    var uiState: RestaurantInfoData by mutableStateOf(RestaurantInfoData())
        private set

    suspend fun fetchRestaurantInfo(restaurantId: Int) {
        try {
            val result = fetchRestaurantUseCase.invoke(restaurantId)
            uiState = result
        } catch (e: Exception) {
            Log.e(tag, "failed load restaurant info: ${e.message.toString()}")
        }
    }

    suspend fun fetchRestaurantInfo1(restaurantId: Int): RestaurantInfoData {
        return getRestaurantInfoUseCase.invoke(restaurantId)
    }
}
package com.sarang.torang.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sarang.torang.uistate.RestaurantInfoUIState
import com.sarang.torang.usecase.GetRestaurantInfoUseCase
import com.sarang.torang.usecase.RestaurantInfoService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantInfoViewModel @Inject constructor(
    private val restaurantInfoService: RestaurantInfoService,
) :
    ViewModel() {
    val tag = "__RestaurantInfoViewModel"
    var uiState: RestaurantInfoUIState by mutableStateOf(RestaurantInfoUIState.Loading)
        private set

    suspend fun fetchRestaurantInfo(restaurantId: Int) {
        try {
            uiState = restaurantInfoService.loadRestaurant(restaurantId)
            uiState = (uiState as RestaurantInfoUIState.Success).copy(
                reviews = restaurantInfoService.loadReviews(restaurantId = restaurantId)
            )
        } catch (e: Exception) {
            uiState = RestaurantInfoUIState.Error(e.message.toString())
            Log.e(tag, "failed load restaurant info: ${e.message.toString()}")
        }
    }
}
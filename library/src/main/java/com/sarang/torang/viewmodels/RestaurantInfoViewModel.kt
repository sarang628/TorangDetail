package com.sarang.torang.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sarang.torang.data.restaurant.RestaurantInfoData
import com.sarang.torang.usecase.GetRestaurantInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantInfoViewModel @Inject constructor(
    private val getRestaurantInfoUseCase: GetRestaurantInfoUseCase
) :
    ViewModel() {
    val tag = "__RestaurantInfoViewModel"
    var uiState: RestaurantInfoData by mutableStateOf(RestaurantInfoData())
        private set

    suspend fun fetchRestaurantInfo1(restaurantId: Int): RestaurantInfoData {
        return getRestaurantInfoUseCase.invoke(restaurantId)
    }
}
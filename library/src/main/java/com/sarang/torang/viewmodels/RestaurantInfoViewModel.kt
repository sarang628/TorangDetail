package com.sarang.torang.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.data.restaurant.RestaurantInfo
import com.sarang.torang.uistate.RestaurantInfoUIState
import com.sarang.torang.usecase.GetRestaurantGalleryUseCase
import com.sarang.torang.usecase.GetRestaurantInfoUseCase
import com.sarang.torang.usecase.RestaurantInfoService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantInfoViewModel @Inject constructor(
    private val restaurantInfoService: RestaurantInfoService
) :
    ViewModel() {
    private var _uiState = MutableStateFlow(RestaurantInfoUIState())
    var uiState = _uiState.asStateFlow()
    suspend fun loadInfo(restaurantId: Int) {
        try {
            _uiState.value = restaurantInfoService.loadRestaurant(restaurantId)
            _uiState.value = _uiState.value.copy(
                reviews = restaurantInfoService.loadReviews(restaurantId = restaurantId)
            )
        } catch (e: Exception) {
            _uiState.update { it.copy(errorMessage = e.message) }
        }
    }
}
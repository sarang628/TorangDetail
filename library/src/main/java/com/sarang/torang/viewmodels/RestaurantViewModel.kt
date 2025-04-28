package com.sarang.torang.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.uistate.RestaurantInfoUIState
import com.sarang.torang.usecase.RestaurantInfoService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(val restaurantInfoService: RestaurantInfoService) :
    ViewModel() {
    var uiState: RestaurantInfoUIState by mutableStateOf(RestaurantInfoUIState.Loading)
        private set

    fun loadRestaurant(restaurantId: Int) {
        viewModelScope.launch {
            try {
                uiState = restaurantInfoService.loadRestaurant(restaurantId)
                /*_uiState.value = _uiState.value.copy(
                    reviews = restaurantInfoService.loadReviews(restaurantId = restaurantId)
                )*/
            } catch (e: Exception) {
                uiState = RestaurantInfoUIState.Error(e.message.toString())
                //_uiState.update { it.copy(errorMessage = e.message) }
            }
        }
    }

    fun clearErrorMessage() {
        //_uiState.update { it.copy(errorMessage = null) }
    }
}
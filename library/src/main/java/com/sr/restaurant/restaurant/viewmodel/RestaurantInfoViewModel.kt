package com.sr.restaurant.restaurant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sr.restaurant.restaurant.usecase.RestaurantInfoService
import dagger.hilt.android.lifecycle.HiltViewModel
import com.sr.restaurant.restaurant.data.RestaurantInfoData
import com.sr.restaurant.restaurant.data.ReviewRowData
import com.sr.restaurant.restaurant.data.ReviewSummaryData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantInfoViewModel @Inject constructor(val restaurantInfoService: RestaurantInfoService) :
    ViewModel() {

    private var _uiState = MutableStateFlow(
        RestaurantInfoUIState(
            reviewRowData = ArrayList<ReviewRowData>().apply {
                //add(testReviewRowData())
            },
            reviewSummaryData = ReviewSummaryData(
                rating = 0f,
                totalReviewer = 0,
                score1 = 0f,
                score2 = 0f,
                score3 = 0f,
                score4 = 0f,
                score5 = 0f
            ),
            menus = ArrayList(),
            restaurantImage = ArrayList(),
            reviews = ArrayList()
        )
    )

    var uiState = _uiState.asStateFlow()
    fun loadRestaurant(restaurantId: Int) {
        viewModelScope.launch {
            try {
                _uiState.value = restaurantInfoService.loadRestaurant(restaurantId)

                _uiState.value = _uiState.value.copy(
                    reviews = restaurantInfoService.loadReviews(restaurantId = restaurantId)
                )


            } catch (e: Exception) {
                _uiState.emit(
                    uiState.value.copy(
                        errorMessage = e.message
                    )
                )
            }
        }
    }

    fun clearErrorMessage() {
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(
                    errorMessage = null
                )
            )
        }
    }
}
package com.sarang.torang.uistate

import com.sarang.torang.data.restaurant.Feed
import com.sarang.torang.data.restaurant.MenuData
import com.sarang.torang.data.restaurant.RestaurantImage
import com.sarang.torang.data.restaurant.RestaurantInfoData
import com.sarang.torang.data.restaurant.ReviewRowData
import com.sarang.torang.data.restaurant.ReviewSummaryData

sealed interface RestaurantInfoUIState {
    object Loading : RestaurantInfoUIState
    data class Error(val msg: String) : RestaurantInfoUIState
    data class Success(
        val restaurantInfoData: RestaurantInfoData = RestaurantInfoData(),
        val errorMessage: String? = null,
    ) : RestaurantInfoUIState
}
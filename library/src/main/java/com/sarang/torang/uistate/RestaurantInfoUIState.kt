package com.sarang.torang.uistate

import com.sarang.torang.data.restaurant.Feed
import com.sarang.torang.data.restaurant.MenuData
import com.sarang.torang.data.restaurant.RestaurantImage
import com.sarang.torang.data.restaurant.RestaurantInfoData
import com.sarang.torang.data.restaurant.ReviewRowData
import com.sarang.torang.data.restaurant.ReviewSummaryData

/*data class RestaurantInfoUIState(
    val restaurantInfoData: RestaurantInfo = RestaurantInfo(),
    val reviewRowData: List<ReviewRowData> = arrayListOf(),
    val reviewSummaryData: ReviewSummaryData = ReviewSummaryData(),
    val menus: List<MenuData> = arrayListOf(),
    val restaurantImage: List<RestaurantImage> = arrayListOf(),
    val errorMessage: String? = null,
    val reviews: List<Feed> = arrayListOf()
)*/


sealed interface RestaurantInfoUIState {
    object Loading : RestaurantInfoUIState
    data class Error(val msg: String) : RestaurantInfoUIState
    data class Success(
        val restaurantInfoData: RestaurantInfoData = RestaurantInfoData(),
        val reviewRowData: List<ReviewRowData> = arrayListOf(),
        val reviewSummaryData: ReviewSummaryData = ReviewSummaryData(),
        val menus: List<MenuData> = arrayListOf(),
        val restaurantImage: List<RestaurantImage> = arrayListOf(),
        val errorMessage: String? = null,
        val reviews: List<Feed> = arrayListOf()
    ) : RestaurantInfoUIState
}
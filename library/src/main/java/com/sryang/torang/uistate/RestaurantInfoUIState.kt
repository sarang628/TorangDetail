package com.sryang.torang.uistate

import com.sryang.torang.data.restaurant.Feed
import com.sryang.torang.data.restaurant.MenuData
import com.sryang.torang.data.restaurant.RestaurantImage
import com.sryang.torang.data.restaurant.RestaurantInfo
import com.sryang.torang.data.restaurant.ReviewRowData
import com.sryang.torang.data.restaurant.ReviewSummaryData

data class RestaurantInfoUIState(
    val restaurantInfoData: RestaurantInfo = RestaurantInfo(),
    val reviewRowData: List<ReviewRowData> = arrayListOf(),
    val reviewSummaryData: ReviewSummaryData = ReviewSummaryData(),
    val menus: List<MenuData> = arrayListOf(),
    val restaurantImage: List<RestaurantImage> = arrayListOf(),
    val errorMessage: String? = null,
    val reviews: List<Feed> = arrayListOf()
)

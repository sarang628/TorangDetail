package com.sr.restaurant.restaurant.viewmodel

import com.sr.restaurant.restaurant.data.FeedData
import com.sr.restaurant.restaurant.data.MenuData
import com.sr.restaurant.restaurant.data.RestaurantImage
import com.sr.restaurant.restaurant.data.RestaurantInfoData
import com.sr.restaurant.restaurant.data.ReviewRowData
import com.sr.restaurant.restaurant.data.ReviewSummaryData

data class RestaurantInfoUIState(
    val restaurantInfoData: RestaurantInfoData,
    val reviewRowData: List<ReviewRowData>,
    val reviewSummaryData: ReviewSummaryData,
    val menus: List<MenuData>,
    val restaurantImage: List<RestaurantImage>,
    val errorMessage: String? = null,
    val reviews: List<FeedData>
)

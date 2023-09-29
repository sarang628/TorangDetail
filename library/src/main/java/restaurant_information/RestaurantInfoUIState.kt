package restaurant_information

import data.MenuData
import data.RestaurantImage
import data.RestaurantInfoData
import data.ReviewRowData
import data.ReviewSummaryData

data class RestaurantInfoUIState(
    val restaurantInfoData: RestaurantInfoData,
    val reviewRowData: List<ReviewRowData>,
    val reviewSummaryData: ReviewSummaryData,
    val menus: List<MenuData>,
    val restaurantImage: List<RestaurantImage>,
    val errorMessage: String? = null
)

package restaurant_information

import data.RestaurantInfoData

interface RestaurantInfoService {
    suspend fun loadRestaurant(restaurantId: Int): RestaurantInfoData
}
package com.sarang.torang.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sarang.torang.data.restaurant.HoursOfOperation
import com.sarang.torang.data.restaurant.RestaurantInfoData
import com.sarang.torang.usecase.GetRestaurantInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.String

@HiltViewModel
class RestaurantInfoViewModel @Inject constructor(
    private val getRestaurantInfoUseCase: GetRestaurantInfoUseCase
) :
    ViewModel() {
    val tag = "__RestaurantInfoViewModel"
    var uiState: RestaurantInfoData by mutableStateOf(RestaurantInfoData())
        private set

    suspend fun fetchRestaurantInfo1(restaurantId: Int) {
        var result = getRestaurantInfoUseCase.invoke(restaurantId)
        uiState = uiState.copy(
            foodType = result.foodType,
            open = result.open,
            close = result.close,
            address = result.address,
            webSite = result.webSite,
            tel = result.tel,
            imageUrl = result.imageUrl,
            name = result.name,
            hoursOfOperation = result.hoursOfOperation,
            rating = result.rating,
            price = result.price,
            reviewCount = result.reviewCount,
            lat = result.lat,
            lon = result.lon
        )
    }

    fun setCurrentLocation(latitude: Double, longitude: Double) {
        uiState = uiState.copy(myLatitude = latitude, myLongitude = longitude)
    }
}
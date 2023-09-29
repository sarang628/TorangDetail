package restaurant_information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.MenuData
import data.RestaurantImage
import data.RestaurantInfoData
import data.ReviewRowData
import data.ReviewSummaryData
import data.testMenuData
import data.testRestaurantImage
import data.testReviewRowData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantInfoViewModel @Inject constructor(val restaurantInfoService: RestaurantInfoService) :
    ViewModel() {

    var _uiState = MutableStateFlow(
        RestaurantInfoUIState(
            restaurantInfoData = RestaurantInfoData(
                foodType = "foodType",
                distance = "distance",
                open = "open",
                close = "close",
                address = "address",
                webSite = "webSite",
                tel = "number",
            ),
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
            menus = ArrayList<MenuData>().apply {
                //add(testMenuData())
            },
            restaurantImage = ArrayList<RestaurantImage>().apply {
                //add(testRestaurantImage())
            }
        )
    )

    var uiState = _uiState.asStateFlow()
    fun loadRestaurant(restaurantId: Int) {
        viewModelScope.launch {
            try {
                val result = restaurantInfoService.loadRestaurant(restaurantId)
                _uiState.emit(
                    uiState.value.copy(
                        //restaurantInfoData = result
                    )
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
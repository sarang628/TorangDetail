package com.sarang.torang.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.data.restaurant.Feed
import com.sarang.torang.usecase.FetchReviewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RestaurantFeedsViewModel @Inject constructor(
    val fetchReviewUseCase: FetchReviewsUseCase
) : ViewModel() {

    var uiState: List<Feed> by mutableStateOf(ArrayList())

    fun fetch(restaurantId: Int) {
        viewModelScope.launch {
            uiState = fetchReviewUseCase.invoke(restaurantId)
        }
    }
}
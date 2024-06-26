package com.sarang.torang.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sarang.torang.data.restaurant.RestaurantImage
import com.sarang.torang.usecase.GetRestaurantGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantGalleryViewModel @Inject constructor(
    private val getRestaurantGalleryUseCase: GetRestaurantGalleryUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<RestaurantImage>>(arrayListOf())
    val uiState = _uiState.asStateFlow()
    suspend fun loadImage(restaurantId: Int) {
        viewModelScope.launch {
            try {
                _uiState.update { getRestaurantGalleryUseCase.invoke(restaurantId) }
            } catch (e: Exception) {

            }
        }
    }
}
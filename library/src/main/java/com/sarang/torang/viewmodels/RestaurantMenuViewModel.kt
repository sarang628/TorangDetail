package com.sarang.torang.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sryang.torang.data.restaurant.MenuData
import com.sryang.torang.usecase.GetMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantMenuViewModel @Inject constructor(val getMenuUseCase: GetMenuUseCase) :
    ViewModel() {
    private var _uiState = MutableStateFlow<List<MenuData>>(ArrayList())
    var uiState = _uiState.asStateFlow()
    suspend fun loadMenu(restaurantId: Int) {
        viewModelScope.launch {
            try {
                _uiState.update {
                    getMenuUseCase.invoke(restaurantId)
                }
            } catch (e: Exception) {

            }
        }
    }
}
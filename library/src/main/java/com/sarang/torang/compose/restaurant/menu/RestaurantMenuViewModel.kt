package com.sarang.torang.compose.restaurant.menu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.data.restaurant.MenuData
import com.sarang.torang.usecase.GetMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantMenuViewModel @Inject constructor(val getMenuUseCase: GetMenuUseCase) :
    ViewModel() {
    val tag = "__RestaurantMenuViewModel"
    var uiState: List<MenuData> by mutableStateOf(ArrayList())
        private set

    fun loadMenu(restaurantId: Int) {
        viewModelScope.launch {
            try {
                uiState = getMenuUseCase.invoke(restaurantId)
            } catch (e: Exception) {
                Log.e(tag, "$e")
            }
        }
    }
}
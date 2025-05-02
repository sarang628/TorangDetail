package com.sarang.torang.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.usecase.GetRestaurantInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantNavViewModel @Inject constructor(
    val restaurantInfoUseCase: GetRestaurantInfoUseCase
) : ViewModel() {
    var restaurantName : String by mutableStateOf("")
    val tag = "__RestaurantNavViewModel"
    fun fetch(restaurantId: Int) {
        viewModelScope.launch {
            try {
                restaurantName = restaurantInfoUseCase.invoke(restaurantId).name
            } catch (e: Exception) {
                Log.e(tag, "$e")
            }
        }
    }
}
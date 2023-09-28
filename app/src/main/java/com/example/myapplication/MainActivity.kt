package com.example.myapplication

import RestaurantScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import restaurant_information.RestaurantInfoViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val restaurantInfoViewModel: RestaurantInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantScreen(
                restaurantInfoViewModel = restaurantInfoViewModel,
                restaurantId = 10
            )
        }
    }
}
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantScreen(
                restaurantId = 1,
                reviewImageUrl = "http://sarang628.iptime.org:89/review_images/",
                restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/"
            )
        }
    }
}
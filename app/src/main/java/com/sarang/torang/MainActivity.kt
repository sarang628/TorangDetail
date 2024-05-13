package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.samples.apps.sunflower.ui.TorangTheme
import com.sarang.torang.compose.restaurant.RestaurantNavScreen
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.info.RestaurantInfoScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sryang.torang.compose.feed.Feeds
import com.sryang.torang.uistate.FeedsUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    RestaurantGalleryScreen(restaurantId = 6)
//                    RestaurantInfoScreen(restaurantId = 6)
//                    RestaurantMenuScreen(restaurantId = 6)
                    Restaurant()
                }
            }
        }
    }
}

@Composable
fun Restaurant() {
    RestaurantNavScreen(
        restaurantId = 6,
        feeds = {
            Box {
                Feeds(
                    onRefresh = { },
                    onBottom = {},
                    isRefreshing = false,
                    ratingBar = { _, _ -> },
                    FeedsUiState.Success(ArrayList())
                )
            }
        },
        map = null
    )
}
package com.sryang.torang

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
import com.sryang.base.feed.compose.feed.Feeds
import com.sryang.torang.compose.restaurant.RestaurantNavScreen
import com.sryang.torang.compose.restaurant.gallery.RestaurantGallery
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
                    RestaurantGallery(restaurantId = 5)
                }
            }
        }
    }
}

@Composable
fun Restaurant() {
    val profileImageServerUrl = "http://sarang628.iptime.org:89/profile_images/"
    val reviewImageUrl = "http://sarang628.iptime.org:89/review_images/"
    RestaurantNavScreen(
        restaurantId = 117,
        reviewImageUrl = "http://sarang628.iptime.org:89/review_images/",
        restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
        menuImageServerUrl = "http://sarang628.iptime.org:89/menu_images/",
        feeds = {
            Box {
                Feeds(
                    list = ArrayList(),
                    onProfile = { },
                    onMenu = { },
                    onImage = { },
                    onName = {},
                    onLike = { },
                    onComment = { },
                    onShare = { },
                    onFavorite = { },
                    onRestaurant = { },
                    profileImageServerUrl = profileImageServerUrl,
                    imageServerUrl = reviewImageUrl,
                    isRefreshing = false,
                    onRefresh = { },
                    ratingBar = {},
                    isEmpty = false,
                    onBottom = {}
                )
            }
        }
    )
}
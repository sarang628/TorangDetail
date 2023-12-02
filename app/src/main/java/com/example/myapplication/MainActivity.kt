package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.samples.apps.sunflower.ui.TorangTheme
import com.sr.restaurant.restaurant.compose.RestaurantScreen
import com.sryang.base.feed.compose.feed.Feeds
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val profileImageServerUrl = "http://sarang628.iptime.org:89/profile_images/"
    val reviewImageUrl = "http://sarang628.iptime.org:89/review_images/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantScreen(
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
            }
        }
    }
}
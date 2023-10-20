package com.example.myapplication

import com.sr.restaurant.restaurant.compose.RestaurantScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.myapplication.di.restaurant_detail.toFeedUiState
import com.sarang.base_feed.ui.Feeds
import dagger.hilt.android.AndroidEntryPoint
import kotlin.streams.toList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val profileImageServerUrl = "http://sarang628.iptime.org:89/profile_images/"
    val reviewImageUrl = "http://sarang628.iptime.org:89/review_images/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantScreen(
                restaurantId = 1,
                reviewImageUrl = "http://sarang628.iptime.org:89/review_images/",
                restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                menuImageServerUrl = "http://sarang628.iptime.org:89/menu_images/",
                feeds = {
                    Box(modifier = Modifier.background(colorResource(id = R.color.colorSecondaryLight))) {
                        Feeds(
                            list = ArrayList(it.stream().map { it.toFeedUiState() }.toList()),
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
                        )
                    }
                }
            )
        }
    }
}
package com.sr.restaurant.restaurant.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sr.restaurant.restaurant.compose.info.RestaurantInfo
import com.sr.restaurant.restaurant.compose.gallery.RestaurantGallery
import com.sr.restaurant.restaurant.compose.menu.RestaurantMenu
import com.sr.restaurant.restaurant.data.FeedData
import com.sr.restaurant.restaurant.viewmodel.RestaurantInfoViewModel

@Composable
fun RestaurantScreen(
    restaurantId: Int,
    restaurantInfoViewModel: RestaurantInfoViewModel = hiltViewModel(),
    reviewImageUrl: String,
    restaurantImageUrl: String,
    menuImageServerUrl: String,
    feeds: @Composable (List<FeedData>) -> Unit
) {
    val navController = rememberNavController()
    restaurantInfoViewModel.loadRestaurant(restaurantId = restaurantId)
    val uiState by restaurantInfoViewModel.uiState.collectAsState()
    Box {
        Column {
            RestaurntTopMenu1(navController)
            NavHost(navController = navController, startDestination = "info") {
                composable("info") {
                    RestaurantInfo(
                        uiState = uiState,
                        reviewImageUrl = reviewImageUrl,
                        restaurantImageUrl = restaurantImageUrl,
                        onClearErrorMessage = {
                            restaurantInfoViewModel.clearErrorMessage()
                        }
                    )
                }
                composable("menu") {
                    RestaurantMenu(list = uiState.menus, menuImageServerUrl = menuImageServerUrl)
                }
                composable("review") {
                    feeds.invoke(uiState.reviews)
                }
                composable("gallery") {
                    RestaurantGallery(
                        uiState.restaurantImage,
                        reviewImageUrl = reviewImageUrl
                    )
                }
            }
        }
    }

}
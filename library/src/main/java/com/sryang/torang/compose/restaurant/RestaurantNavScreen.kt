package com.sryang.torang.compose.restaurant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sryang.torang.compose.restaurant.gallery.RestaurantGallery
import com.sryang.torang.compose.restaurant.info.RestaurantInfo
import com.sryang.torang.compose.restaurant.menu.RestaurantMenu
import com.sryang.torang.data.restaurant.Feed
import com.sryang.torang.viewmodels.RestaurantInfoViewModel
import kotlinx.coroutines.launch

@Composable
fun RestaurantNavScreen(
    restaurantId: Int,
    restaurantInfoViewModel: RestaurantInfoViewModel = hiltViewModel(),
    reviewImageUrl: String,
    restaurantImageUrl: String,
    menuImageServerUrl: String,
    feeds: @Composable (List<Feed>) -> Unit
) {
    val navController = rememberNavController()
    val uiState by restaurantInfoViewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = restaurantId, block = {
        restaurantInfoViewModel.loadRestaurant(restaurantId = restaurantId)
    })

    LaunchedEffect(key1 = uiState.errorMessage, block = {
        uiState.errorMessage?.let {
            coroutine.launch {
                snackbarHostState.showSnackbar(it, duration = SnackbarDuration.Short)
                restaurantInfoViewModel.clearErrorMessage()
            }
        }
    })

    Scaffold(snackbarHost = {
        SnackbarHost(snackbarHostState)
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
            RestaurntTopMenu1(navController)
            NavHost(navController = navController, startDestination = "info") {
                composable("info") {
                    RestaurantInfo(
                        uiState = uiState,
                        reviewImageUrl = reviewImageUrl,
                        restaurantImageUrl = restaurantImageUrl
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
package com.sarang.torang.compose.restaurant

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.info.RestaurantInfoScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sarang.torang.viewmodels.RestaurantViewModel
import kotlinx.coroutines.launch

@Composable
fun RestaurantNavScreen(
    restaurantId: Int,
    restaurantInfoViewModel: RestaurantViewModel = hiltViewModel(),
    onWeb: ((String) -> Unit)? = null,
    onCall: ((String) -> Unit)? = null,
    onImage: ((Int) -> Unit)? = null,
    feeds: @Composable (Int) -> Unit,
    image: @Composable ((
        Modifier,
        String,
        Dp?,
        Dp?,
        ContentScale?,
    ) -> Unit)? = null,
    map: @Composable ((String, Double, Double, String) -> Unit)? = null,
) {
    //var show: String? by remember { mutableStateOf(null) }
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
                snackbarHostState.showSnackbar(message = it, duration = SnackbarDuration.Short)
                restaurantInfoViewModel.clearErrorMessage()
            }
        }
    })

    Scaffold(snackbarHost = {
        SnackbarHost(snackbarHostState)
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
            RestaurntTopMenu(navController)
            NavHost(navController = navController, startDestination = "info") {
                composable("info") {
                    RestaurantInfoScreen(
                        restaurantId = restaurantId,
                        onWeb = onWeb,
                        onCall = {
                            onCall?.invoke(it)
                        },
                        map = map,
                        image = image,
                        onImage = onImage
                    )
                }
                composable("menu") {
                    RestaurantMenuScreen(restaurantId = restaurantId)
                }
                composable("review") {
                    feeds.invoke(restaurantId)
                }
                composable("gallery") {
                    RestaurantGalleryScreen(restaurantId = restaurantId, image = image)
                }
            }
        }
    }

    /*if (show != null) {
        SimplePermissionDialog(
            permission = Manifest.permission.CALL_PHONE,
            permissionMessage = "require phone call permission",
            onPermissionRequest = {
                if (it == 0) {
                    show?.let { onCall?.invoke(it) }
                    show = null
                }
            },
            onCancle = { show = null }
        )
    }*/

}
package com.sarang.torang.compose.restaurant.detail

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.data.restaurant.Feed

/**
 * @param map map compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailNavigationScreen(
    restaurantId: Int,
    onWeb: (String) -> Unit = {},
    onCall: (String) -> Unit = {},
    onImage: (Int) -> Unit = {},
    progressTintColor: Color? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onProfile: (Int) -> Unit = {},
    onContents: (Int) -> Unit = {},
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    /**
     * @param String title of restaurant
     * @param Double latitude
     * @param Double longitude
     * @param Double type of food
     */
    map: @Composable ((String, Double, Double, String) -> Unit)? = null,
    onError: (String) -> Unit = {},
    feed: @Composable (Feed) -> Unit = {},
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit), contents: @Composable (() -> Unit)) -> Unit = { _, _, _ -> }
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "info") {
        composable("info") {

            RestaurantDetailScreen(
                restaurantId = restaurantId,
                onCall = onCall,
                onWeb = onWeb,
                onLocation = { navController.navigate("map") },
                onImage = onImage,
                imageLoader = imageLoader,
                scrollBehavior = scrollBehavior,
                progressTintColor = progressTintColor,
                onContents = onContents,
                onProfile = onProfile,
                feed = feed
            )

            /* is RestaurantInfoUIState.Error -> {
                 onError.invoke(uiState.msg)
                 Box(Modifier.fillMaxSize()) {
                     Button(
                         modifier = Modifier.align(Alignment.Center),
                         onClick = {},
                         contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                     ) {
                         Row(verticalAlignment = Alignment.CenterVertically) {
                             Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                             Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                             Text("refresh")
                         }
                     }
                 }
             }*/

            /*is RestaurantInfoUIState.Loading -> {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }*/

        }
        composable("map") {
            if (map == null) {
                Log.w("__RestaurantInfoScreen", "not assigned map composable!")
            }
        }
    }
}
package com.sarang.torang

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.samples.apps.sunflower.ui.TorangTheme
import com.sarang.torang.compose.restaurant.RestaurantNavScreen
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.info.RestaurantInfoScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sryang.library.compose.SimplePermissionDialog
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
    var show by remember { mutableStateOf(false) }
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
        onCall = {
            show = true
        },
        map = null
    )
    if (show) {
        val context = LocalContext.current
        SimplePermissionDialog(
            permission = Manifest.permission.CALL_PHONE,
            permissionMessage = "require phone call permission",
            onPermissionRequest = {
                if (it == 0) {
                    Toast.makeText(context, "call", Toast.LENGTH_SHORT).show()
                    show = false
                }
            },
            onCancle = { show = false }
        )
    }
}
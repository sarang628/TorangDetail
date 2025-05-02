package com.sarang.torang.compose.restaurant

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.detail.RestaurantDetailNavigationScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantNavScreen(
    tag : String = "__RestaurantNavScreen",
    restaurantId: Int,
    onWeb: (String) -> Unit = { { Log.w(tag, "onWeb doesn't set") } },
    onCall: (String) -> Unit = { { Log.w(tag, "onCall doesn't set") } },
    onImage: (Int) -> Unit = { { Log.w(tag, "onImage doesn't set") } },
    feeds: @Composable (Int, Modifier) -> Unit = {_,_-> { Log.w(tag, "feeds doesn't set") } },
    progressTintColor: Color? = null,
    onProfile: (Int) -> Unit = { { Log.w(tag, "onProfile doesn't set") } },
    onContents: (Int) -> Unit = { { Log.w(tag, "onContents doesn't set") } },
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _,_,_,_,_->  Log.w(tag, "image doesn't set") },
    map: @Composable (String, Double, Double, String) -> Unit = { _,_,_,_-> Log.w(tag, "map doesn't set") },
    onBack: (() -> Unit) = { Log.w(tag, "map doesn't set") },
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit), contents: @Composable () -> Unit) -> Unit = { _, _, contents -> Log.w("__RestaurantInfoScreen", "pullToRefreshLayout is null"); contents() }
) {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutine = rememberCoroutineScope()
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                title = {
                    Text(
                        //text = uiState.restaurantInfoData.name,
                        text = "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }, scrollBehavior = scrollBehavior
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
            RestaurntTopMenu(navController)
            NavHost(navController = navController, startDestination = "info") {
                composable("info") {
                    RestaurantDetailNavigationScreen(
                        restaurantId = restaurantId,
                        onWeb = onWeb,
                        onCall = { onCall.invoke(it) },
                        map = map,
                        imageLoader = imageLoader,
                        onImage = onImage,
                        scrollBehavior = scrollBehavior,
                        progressTintColor = progressTintColor,
                        onProfile = onProfile,
                        onContents = onContents,
                        onError = { coroutine.launch { snackbarHostState.showSnackbar(it) } },
                        pullToRefreshLayout = pullToRefreshLayout
                    )
                }
                composable("menu") {
                    RestaurantMenuScreen(
                        restaurantId = restaurantId,
                        progressTintColor = progressTintColor,
                        imageLoader = imageLoader,
                        pullToRefreshLayout = pullToRefreshLayout
                    )
                }
                composable("review") {
                    feeds.invoke(
                        restaurantId,
                        Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
                    )
                }
                composable("gallery") {
                    RestaurantGalleryScreen(
                        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                        restaurantId = restaurantId,
                        image = imageLoader,
                        onImage = { onImage.invoke(it) },
                        pullToRefreshLayout = pullToRefreshLayout)
                }
            }
        }
    }
}
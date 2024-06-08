package com.sarang.torang.compose.restaurant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.info.RestaurantInfoScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sarang.torang.viewmodels.RestaurantViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantNavScreen(
    restaurantId: Int,
    restaurantInfoViewModel: RestaurantViewModel = hiltViewModel(),
    onWeb: ((String) -> Unit)? = null,
    onCall: ((String) -> Unit)? = null,
    onImage: ((Int) -> Unit)? = null,
    feeds: @Composable (Int, Modifier) -> Unit,
    progressTintColor: Color? = null,
    onProfile: (Int) -> Unit,
    onContents: (Int) -> Unit,
    image: @Composable ((
        Modifier,
        String,
        Dp?,
        Dp?,
        ContentScale?,
    ) -> Unit)? = null,
    map: @Composable ((String, Double, Double, String) -> Unit)? = null,
    onBack: (() -> Unit),
) {
    val navController = rememberNavController()
    val uiState by restaurantInfoViewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutine = rememberCoroutineScope()
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

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
                        text = "${uiState.restaurantInfoData.name}",
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
                    RestaurantInfoScreen(
                        restaurantId = restaurantId,
                        onWeb = onWeb,
                        onCall = {
                            onCall?.invoke(it)
                        },
                        map = map,
                        image = image,
                        onImage = onImage,
                        scrollBehavior = scrollBehavior,
                        progressTintColor = progressTintColor,
                        onProfile = onProfile,
                        onContents = onContents
                    )
                }
                composable("menu") {
                    RestaurantMenuScreen(
                        restaurantId = restaurantId,
                        progressTintColor = progressTintColor
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
                        image = image,
                        onImage = { onImage?.invoke(it) })
                }
            }
        }
    }
}
package com.sarang.torang.compose.restaurant.info

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.compose.restaurant.menu.PreviewRestaurantMenuColumn
import com.sarang.torang.data.restaurant.MenuData
import com.sarang.torang.data.restaurant.RestaurantImage
import com.sarang.torang.data.restaurant.ReviewRowData
import com.sarang.torang.data.restaurant.testRestaurantInfo1
import com.sarang.torang.uistate.RestaurantInfoUIState
import com.sarang.torang.viewmodels.RestaurantInfoViewModel
import kotlinx.coroutines.launch

/**
 * @param map map compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailNavigationScreen(
    restaurantInfoViewModel: RestaurantInfoViewModel = hiltViewModel(),
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
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit), contents: @Composable (() -> Unit)) -> Unit = { _, _, _ -> }
) {
    val navController = rememberNavController()
    val coroutine = rememberCoroutineScope()
    val uiState = restaurantInfoViewModel.uiState
    LaunchedEffect(key1 = restaurantId, block = {
        restaurantInfoViewModel.fetchRestaurantInfo(restaurantId)
    })

    NavHost(navController = navController, startDestination = "info") {
        composable("info") {
            when (uiState) {
                is RestaurantInfoUIState.Success -> {
                    RestaurantDetailScreen(
                        uiState = uiState as RestaurantInfoUIState.Success,
                        onRefresh = {
                            coroutine.launch {
                                restaurantInfoViewModel.fetchRestaurantInfo(restaurantId)
                                //it.updateState(RefreshIndicatorState.Default)
                            }
                        },
                        onCall = onCall,
                        onWeb = onWeb,
                        onLocation = { navController.navigate("map") },
                        onImage = onImage,
                        imageLoader = imageLoader,
                        scrollBehavior = scrollBehavior,
                        progressTintColor = progressTintColor,
                        onContents = onContents,
                        onProfile = onProfile
                    )
                }

                is RestaurantInfoUIState.Error -> {
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
                }

                is RestaurantInfoUIState.Loading -> {
                    Box(Modifier.fillMaxSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                }
            }
        }
        composable("map") {
            if (map == null) {
                Log.w("__RestaurantInfoScreen", "not assigned map composable!")
            }
            when (uiState) {
                is RestaurantInfoUIState.Error -> TODO()
                RestaurantInfoUIState.Loading -> TODO()
                is RestaurantInfoUIState.Success -> {
                    map?.invoke(
                        uiState.restaurantInfoData.name,
                        uiState.restaurantInfoData.lat,
                        uiState.restaurantInfoData.lon,
                        uiState.restaurantInfoData.foodType
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreen(
    uiState: RestaurantInfoUIState.Success,
    onRefresh: () -> Unit = { Log.w("__RestaurantInfoScreen", "onRefreshListener is null") },
    onLocation: () -> Unit = { },
    onWeb: (String) -> Unit = { },
    onCall: (String) -> Unit = { },
    onImage: (Int) -> Unit = { },
    progressTintColor: Color? = null,
    onProfile: (Int) -> Unit = {},
    onContents: (Int) -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit), contents: @Composable (() -> Unit)) -> Unit = { _, _, contents -> Log.w("__RestaurantInfoScreen", "pullToRefreshLayout is null"); contents() }
) {
    val state = rememberPullToRefreshState()
    pullToRefreshLayout.invoke(
        false,
        { onRefresh.invoke() }) {
        LazyColumn(
            modifier = if (scrollBehavior != null) Modifier.nestedScroll(scrollBehavior.nestedScrollConnection) else Modifier,
            content = {
                items(6) {
                    if (it == 0) {
                        RestaurantInfo( // 레스토랑 기본정보
                            restaurantInfoData = uiState.restaurantInfoData,
                            onLocation = onLocation,
                            onWeb = { onWeb.invoke(uiState.restaurantInfoData.webSite) },
                            onCall = { onCall.invoke(uiState.restaurantInfoData.tel) },
                            progressTintColor = progressTintColor,
                            imageLoader = imageLoader
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 1) {
                        Column {
                            RestaurantInfoTitle(title = "Menus")
                            PreviewRestaurantMenuColumn(
                                imageLoader = imageLoader
                            )
                        }
                    } else if (it == 2) {
                        RestaurantImages( // 레스토랑 이미지
                            list = uiState.restaurantImage,
                            image = imageLoader,
                            onImage = onImage
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 3) {
                        RestaurantMenus(menus = uiState.menus) // 레스토랑 메뉴
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 4) {
                        RestaurantReviewSummary( // 레스토랑 리뷰요약
                            uiState.reviewSummaryData,
                            progressTintColor = progressTintColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 5) {
                        RestaurantReviews( // 레스토랑 리뷰
                            uiState.reviewRowData,
                            progressTintColor = progressTintColor,
                            onProfile = onProfile,
                            onContents = onContents
                        )
                    }
                }
            })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewRestaurantInfoScreen() {
    RestaurantDetailScreen(
        uiState = RestaurantInfoUIState.Success().copy(
            restaurantInfoData = testRestaurantInfo1(),
            restaurantImage = listOf(
                RestaurantImage.empty(),
                RestaurantImage.empty(),
                RestaurantImage.empty()
            ),
            menus = listOf(
                MenuData.empty(),
                MenuData.empty(),
                MenuData.empty(),
                MenuData.empty(),
                MenuData.empty()
            ),
            reviewRowData = listOf(
                ReviewRowData.empty(),
                ReviewRowData.empty(),
                ReviewRowData.empty(),
                ReviewRowData.empty(),
                ReviewRowData.empty()
            )
        )
    )
}

@Preview
@Composable
fun TEST() {
    Button(
        modifier = Modifier,
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
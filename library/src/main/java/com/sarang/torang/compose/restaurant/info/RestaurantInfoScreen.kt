package com.sarang.torang.compose.restaurant.info

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.uistate.RestaurantInfoUIState
import com.sarang.torang.viewmodels.RestaurantInfoViewModel
import com.sryang.library.pullrefresh.PullToRefreshLayout
import com.sryang.library.pullrefresh.PullToRefreshLayoutState
import com.sryang.library.pullrefresh.RefreshIndicatorState
import com.sryang.library.pullrefresh.rememberPullToRefreshState
import kotlinx.coroutines.launch

/**
 * @param map map compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantInfoScreen(
    restaurantInfoViewModel: RestaurantInfoViewModel = hiltViewModel(),
    restaurantId: Int,
    onWeb: ((String) -> Unit)? = null,
    onCall: ((String) -> Unit)? = null,
    onImage: ((Int) -> Unit)? = null,
    progressTintColor: Color? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onProfile: (Int) -> Unit,
    onContents: (Int) -> Unit,
    image: @Composable ((
        Modifier,
        String,
        Dp?,
        Dp?,
        ContentScale?,
    ) -> Unit)? = null,
    /**
     * @param String title of restaurant
     * @param Double latitude
     * @param Double longitude
     * @param Double type of food
     */
    map: @Composable ((String, Double, Double, String) -> Unit)? = null,
) {
    val navController = rememberNavController()
    val coroutine = rememberCoroutineScope()
    val uiState: RestaurantInfoUIState by restaurantInfoViewModel.uiState.collectAsState()
    LaunchedEffect(key1 = restaurantId, block = {
        restaurantInfoViewModel.loadInfo(restaurantId)
    })

    NavHost(navController = navController, startDestination = "info") {
        composable("info") {
            RestaurantInfoScreen(
                uiState = uiState,
                onRefresh = {
                    coroutine.launch {
                        restaurantInfoViewModel.loadInfo(restaurantId)
                        it.updateState(RefreshIndicatorState.Default)
                    }
                }, onCall = { onCall?.invoke(uiState.restaurantInfoData.tel) },
                onWeb = { onWeb?.invoke(uiState.restaurantInfoData.webSite) },
                onLocation = { navController.navigate("map") },
                onImage = onImage,
                image = image,
                scrollBehavior = scrollBehavior,
                progressTintColor = progressTintColor,
                onContents = onContents,
                onProfile = onProfile
            )
        }
        composable("map") {
            if (map == null) {
                Log.w("__RestaurantInfoScreen", "not assigned map composable!")
            }
            map?.invoke(
                uiState.restaurantInfoData.name,
                uiState.restaurantInfoData.lat,
                uiState.restaurantInfoData.lon,
                uiState.restaurantInfoData.foodType
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantInfoScreen(
    uiState: RestaurantInfoUIState,
    onRefresh: ((PullToRefreshLayoutState) -> Unit)? = null,
    onLocation: (() -> Unit)? = null,
    onWeb: (() -> Unit)? = null,
    onCall: (() -> Unit)? = null,
    onImage: ((Int) -> Unit)? = null,
    progressTintColor: Color? = null,
    onProfile: (Int) -> Unit,
    onContents: (Int) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    image: @Composable ((
        Modifier,
        String,
        Dp?,
        Dp?,
        ContentScale?,
    ) -> Unit)? = null,
) {
    val state = rememberPullToRefreshState()
    PullToRefreshLayout(
        pullRefreshLayoutState = state,
        refreshThreshold = 70,
        modifier = Modifier.fillMaxSize(),
        onRefresh = {
            if (onRefresh == null) {
                Log.w("__RestaurantInfoScreen", "onRefreshListener is null")
            }
            onRefresh?.invoke(state)
        }) {
        LazyColumn(
            modifier = if (scrollBehavior != null) Modifier.nestedScroll(scrollBehavior.nestedScrollConnection) else Modifier,
            content = {
                items(5) {
                    if (it == 0) {
                        // 레스토랑 기본정보
                        RestaurantInfo(
                            restaurantInfoData = uiState.restaurantInfoData,
                            onLocation,
                            onWeb,
                            onCall,
                            progressTintColor = progressTintColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 1) {
                        // 레스토랑 이미지
                        RestaurantImages(
                            list = uiState.restaurantImage,
                            image = image,
                            onImage = onImage
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 2) {
                        // 레스토랑 메뉴
                        RestaurantMenus(menus = uiState.menus)
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 3) {
                        // 레스토랑 리뷰요약
                        RestaurantReviewSummary(
                            uiState.reviewSummaryData,
                            progressTintColor = progressTintColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    } else if (it == 4) {
                        // 레스토랑 리뷰
                        RestaurantReviews(
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
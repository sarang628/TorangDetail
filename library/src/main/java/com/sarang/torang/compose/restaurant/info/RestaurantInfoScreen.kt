package com.sarang.torang.compose.restaurant.info

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sryang.library.pullrefresh.PullToRefreshLayout
import com.sryang.library.pullrefresh.PullToRefreshLayoutState
import com.sryang.library.pullrefresh.RefreshIndicatorState
import com.sryang.library.pullrefresh.rememberPullRefreshState
import com.sryang.library.pullrefresh.rememberPullToRefreshState
import com.sarang.torang.uistate.RestaurantInfoUIState
import com.sarang.torang.viewmodels.RestaurantInfoViewModel
import com.sarang.torang.widgets.RatingBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RestaurantInfoScreen(
    restaurantInfoViewModel: RestaurantInfoViewModel = hiltViewModel(),
    restaurantId: Int
) {
    val coroutine = rememberCoroutineScope()
    LaunchedEffect(key1 = restaurantId, block = {
        restaurantInfoViewModel.loadInfo(restaurantId)
    })

    val uiState by restaurantInfoViewModel.uiState.collectAsState()
    RestaurantInfoScreen(
        uiState = uiState,
        onRefresh = {
            coroutine.launch {
                restaurantInfoViewModel.loadInfo(restaurantId)
                it.updateState(RefreshIndicatorState.Default)
            }
        }
    )
}

@Composable
fun RestaurantInfoScreen(
    uiState: RestaurantInfoUIState,
    onRefresh: (PullToRefreshLayoutState) -> Unit,
) {
    val state = rememberPullToRefreshState()
    PullToRefreshLayout(
        pullRefreshLayoutState = state,
        refreshThreshold = 70,
        modifier = Modifier.fillMaxSize(),
        onRefresh = {
            onRefresh.invoke(state)
        }) {
        LazyColumn(content = {
            items(5) {
                if (it == 0) {
                    // 레스토랑 기본정보
                    uiState.restaurantInfoData.let {
                        RestaurantInfo(restaurantInfoData = uiState.restaurantInfoData)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                } else if (it == 1) {
                    // 레스토랑 이미지
                    RestaurantImages(list = uiState.restaurantImage)
                    Spacer(modifier = Modifier.height(8.dp))
                } else if (it == 2) {
                    // 레스토랑 메뉴
                    RestaurantMenus(menus = uiState.menus)
                    Spacer(modifier = Modifier.height(8.dp))
                } else if (it == 3) {
                    // 레스토랑 리뷰요약
                    RestaurantReviewSummary(uiState.reviewSummaryData)
                    Spacer(modifier = Modifier.height(8.dp))
                } else if (it == 4) {
                    // 레스토랑 리뷰
                    RestaurantReviews(uiState.reviewRowData)
                }
            }
        })
    }
}

@Composable
fun RatingInfo(rating: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = rating.toString())
        RatingBar(rating = rating)
    }
}

@Preview
@Composable
fun PreviewRatingInfo() {
    RatingInfo(rating = 3.0f)
}

@Composable
fun RestaurantInfoTitle(title: String) {
    Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
}

@Preview
@Composable
fun RestaurantInfoTitle() {
    RestaurantInfoTitle(title = "메뉴 타이틀")
}

@Preview
@Composable
fun PreviewRestaurantInformation() {
}
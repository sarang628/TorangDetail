package com.sarang.torang.compose.restaurant.detail

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sarang.torang.compose.restaurant.RestaurantFeeds
import com.sarang.torang.compose.restaurant.detail.components.RestaurantInfoTitle
import com.sarang.torang.compose.restaurant.detail.components.RestaurantReservation
import com.sarang.torang.compose.restaurant.menu.PreviewRestaurantMenuColumn
import com.sarang.torang.data.restaurant.Feed

enum class RestaurantDetailOrder{
    RestaurantInfo,
    RestaurantReservation,
    RestaurantImages,
    RestaurantMenu,
    RestaurantMenus,
    RestaurantReviewSummary,
    RestaurantReviews,
    Feed
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreen(
    tag: String = "__RestaurantInfoScreen",
    restaurantId : Int,
    modifier: Modifier = Modifier,
    onRefresh: () -> Unit = { Log.w(tag, "onRefresh is null") },
    onLocation: () -> Unit = { Log.w(tag, "onLocation is null") },
    onWeb: (String) -> Unit = { Log.w(tag, "onWeb is null") },
    onCall: (String) -> Unit = { Log.w(tag, "onCall is null") },
    onImage: (Int) -> Unit = { Log.w(tag, "onImage is null") },
    progressTintColor: Color? = null,
    onProfile: (Int) -> Unit = { Log.w(tag, "onProfile is null") },
    onContents: (Int) -> Unit = { Log.w(tag, "onContents is null") },
    scrollBehavior: TopAppBarScrollBehavior? = null,
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> Log.w(tag, "imageLoader is null") },
    feed: @Composable (Feed) -> Unit = { Log.w(tag, "feed is null") },
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit),
      contents: @Composable (() -> Unit)) -> Unit = { _, _, contents -> Log.w("__RestaurantInfoScreen", "pullToRefreshLayout is null"); contents() }
) {
    pullToRefreshLayout.invoke(false, { onRefresh.invoke() }) {
        LazyColumn(
            modifier = if (scrollBehavior != null) modifier.nestedScroll(scrollBehavior.nestedScrollConnection) else Modifier){
            items(RestaurantDetailOrder.values().size) {
                when(RestaurantDetailOrder.values()[it]){
                    RestaurantDetailOrder.RestaurantInfo -> { // 레스토랑 기본정보
                        RestaurantInfo_( restaurantId = restaurantId, onLocation = onLocation, onWeb = onWeb , onCall = onCall , progressTintColor = progressTintColor, imageLoader = imageLoader)
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    RestaurantDetailOrder.RestaurantImages -> {// 이미지
                        Box(Modifier.padding(start = 8.dp, end = 8.dp)) { RestaurantInfoTitle(title = "Images") }
                        RestaurantImages_(restaurantId = restaurantId, image = imageLoader, onImage = onImage)
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    RestaurantDetailOrder.RestaurantMenu -> { // 메뉴
                        Column(Modifier.padding(start = 8.dp, end = 8.dp)) { RestaurantInfoTitle(title = "Menus"); PreviewRestaurantMenuColumn(imageLoader = imageLoader) }
                    }

                    RestaurantDetailOrder.RestaurantMenus -> { // 메뉴
                        RestaurantMenus_(restaurantId = restaurantId); Spacer(modifier = Modifier.height(16.dp))
                    }

                    RestaurantDetailOrder.RestaurantReviewSummary -> { // 리뷰 통계
                        RestaurantReviewSummary_(restaurantId = restaurantId, progressTintColor = progressTintColor)
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    RestaurantDetailOrder.RestaurantReviews -> { // 리뷰
                        RestaurantReviews_(restaurantId = restaurantId, progressTintColor = progressTintColor, onProfile = onProfile, onContents = onContents)
                    }

                    RestaurantDetailOrder.Feed -> { // 피드
                        Box(Modifier.padding(start = 8.dp, end = 8.dp)) { RestaurantInfoTitle(title = "Reviews") }
                        RestaurantFeeds(restaurantId = restaurantId, feed = feed)
                    }

                    RestaurantDetailOrder.RestaurantReservation -> {
                        RestaurantReservation()
                    }
                }
            }
        }
    }
}
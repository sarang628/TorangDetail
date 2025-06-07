package com.sarang.torang.di.restaurant_detail

import com.sarang.torang.compose.restaurant.PullToRefresh

val customPullToRefresh: PullToRefresh = { isRefreshing, onRefresh, contents ->
    contents.invoke()
}
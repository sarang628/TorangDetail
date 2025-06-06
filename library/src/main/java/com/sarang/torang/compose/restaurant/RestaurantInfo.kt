package com.sarang.torang.compose.restaurant

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

typealias RestaurantInfo = @Composable () -> Unit

val LocalRestaurantInfo = compositionLocalOf<RestaurantInfo> {
    // 기본 구현: 경고 로그 출력
    @Composable {
        Text("TODO")
    }
}
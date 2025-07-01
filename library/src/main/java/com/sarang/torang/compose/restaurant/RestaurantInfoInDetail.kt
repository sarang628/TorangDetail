package com.sarang.torang.compose.restaurant

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

typealias RestaurantDetail = @Composable () -> Unit

val LocalRestaurantDetail = compositionLocalOf<RestaurantDetail> {
    // 기본 구현: 경고 로그 출력
    @Composable {
        Log.w("__RestaurantInfoInDetail", "no RestaurantInfoCompose")
    }
}
package com.sarang.torang.compose.restaurant

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier

typealias Feeds = @Composable (Int, Modifier) -> Unit

val LocalFeeds = compositionLocalOf<Feeds> {
    // 기본 구현: 경고 로그 출력
    @Composable { _, _ ->
        Text("피드 모듈이 등록되지 않았습니다.")
    }
}
package com.sarang.torang.di.image

import TorangAsyncImage
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sarang.torang.compose.restaurant.ImageLoader

fun provideTorangAsyncImage(): @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit =
    { modifier, model, progressSize, errorIconSize, contentScale ->
        TorangAsyncImage(
            modifier = modifier,
            model = model,
            progressSize = progressSize ?: 50.dp,
            errorIconSize = errorIconSize ?: 50.dp,
            contentScale = contentScale ?: ContentScale.Fit
        )
    }

fun provideTorangAsyncImage1(): @Composable (Modifier, String, Dp?, Dp?, ContentScale?, Dp?) -> Unit =
    { modifier, model, progressSize, errorIconSize, contentScale, height ->
        TorangAsyncImage(
            modifier = modifier,
            model = model,
            progressSize = progressSize ?: 50.dp,
            errorIconSize = errorIconSize ?: 50.dp,
            contentScale = contentScale ?: ContentScale.Fit
        )
    }


val customImageLoader: ImageLoader = { modifier, url, width, height, scale ->
    // 여기서 실제 이미지 로딩 구현 예시
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
}
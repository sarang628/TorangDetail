package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.sarang.library.RestaurantDetailNavigationScreen
import com.sarang.library.compose.ImageLoader
import com.sarang.library.compose.LocalPullToRefresh
import com.sarang.library.compose.PullToRefresh
import com.sarang.torang.compose.restaurant.Feeds
import com.sarang.torang.compose.restaurant.LocalFeeds
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
//@formatter:off
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
                    CompositionLocalProvider(
                        LocalImageLoader provides customImageLoader,
                        LocalPullToRefresh provides customPullToRefresh,
                        LocalFeeds provides provideFeeds,
                        LocalRestaurantInfo provides CustomRestaurantInfo,
                    ) {
                        RestaurantNavScreen(restaurantId = 234)// 정보 탭, 메뉴 탭, 갤러리 탭, 리뷰 탭 내비게이션
        //        RestaurantMenuScreen(restaurantId = 234)
        //        RestaurantGalleryScreen(restaurantId = 234)
        //        PreviewRestaurantMenuColumn()
                    }
                }
            }
        }
    }


}
//@formatter:on

@OptIn(ExperimentalMaterial3Api::class)
val CustomRestaurantInfo: RestaurantInfo = { _, _, _, _ ->
    RestaurantDetailNavigationScreen(restaurantId = 234)
}

val customImageLoader: ImageLoader = { modifier, url, width, height, scale ->
    // 여기서 실제 이미지 로딩 구현 예시
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
}

val customPullToRefresh: PullToRefresh = { isRefreshing, onRefresh, contents ->
    contents.invoke()
}

val provideFeeds: Feeds = { modifier, url ->
    // 여기서 실제 이미지 로딩 구현 예시
    Text("TODO")
}
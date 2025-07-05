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
import com.sarang.library.compose.DetailRestaurantInfo
import com.sarang.library.compose.ImageLoader
import com.sarang.library.compose.LocalDetailRestaurantInfo
import com.sarang.library.compose.LocalImageLoader
import com.sarang.library.compose.LocalPullToRefresh
import com.sarang.library.compose.PullToRefresh
import com.sarang.library.compose.restaurantdetail.RestaurantDetailScreen
import com.sarang.torang.compose.restaurant.Feeds
import com.sarang.torang.compose.restaurant.LocalFeeds
import com.sarang.torang.compose.restaurant.LocalRestaurantDetail
import com.sarang.torang.compose.restaurant.RestaurantDetail
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sarang.torang.di.restaurant_info.RestaurantInfoWithPermission
import com.sryang.library.compose.workflow.BestPracticeViewModel
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
                        LocalRestaurantDetail provides customRestaurantDetail
                    ) {
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
val customRestaurantDetail: RestaurantDetail = {
    CompositionLocalProvider(
        LocalDetailRestaurantInfo provides customRestaurantInfo,
        LocalRestaurantInfoImageLoader provides restaurantImageLoader,
    ) {
        RestaurantDetailScreen(restaurantId = 234)
    }
}

val customRestaurantInfo: DetailRestaurantInfo = {
    RestaurantInfoWithPermission(restaurantId = it, viewModel = BestPracticeViewModel())
}

val restaurantImageLoader: RestaurantInfoImageLoader = { modifier, url, width, height, scale ->
    // 여기서 실제 이미지 로딩 구현 예시
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
}


val customImageLoader: ImageLoader = { modifier, url, width, height, scale ->
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale) // 여기서 실제 이미지 로딩 구현 예시
}

val customPullToRefresh: PullToRefresh = { isRefreshing, onRefresh, contents ->
    contents.invoke()
}

val provideFeeds: Feeds = { modifier, url ->
    Text("TODO") // 여기서 실제 이미지 로딩 구현 예시
}
package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.sarang.library.RestaurantDetailNavigationScreen
import com.sarang.torang.compose.restaurant.LocalFeeds
import com.sarang.torang.compose.restaurant.LocalImageLoader
import com.sarang.torang.compose.restaurant.LocalPullToRefresh
import com.sarang.torang.compose.restaurant.LocalRestaurantInfo
import com.sarang.torang.compose.restaurant.RestaurantInfo
import com.sarang.torang.di.image.customImageLoader
import com.sarang.torang.di.torang_detail_di.customPullToRefresh
import com.sarang.torang.di.torang_detail_di.provideFeeds
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
val CustomRestaurantInfo: RestaurantInfo = {
    RestaurantDetailNavigationScreen(restaurantId = 234)
}


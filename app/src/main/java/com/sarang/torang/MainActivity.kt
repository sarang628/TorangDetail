package com.sarang.torang

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sarang.torang.compose.feed.Feed
import com.sarang.torang.compose.restaurant.LocalFeeds
import com.sarang.torang.compose.restaurant.LocalImageLoader
import com.sarang.torang.compose.restaurant.LocalPullToRefresh
import com.sarang.torang.compose.restaurant.PullToRefresh
import com.sarang.torang.compose.restaurant.RestaurantNavScreen
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuColumn
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sarang.torang.data.basefeed.Review
import com.sarang.torang.data.basefeed.User
import com.sarang.torang.data.restaurant.testMenuData
import com.sarang.torang.di.image.customImageLoader
import com.sarang.torang.di.image.provideTorangAsyncImage1
import com.sarang.torang.di.restaurant_detail.provideFeeds
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
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background, content = { Main() } )
            }
        }
    }
}
//@formatter:on

@RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
@Composable
fun Main() {
    CompositionLocalProvider(LocalImageLoader provides customImageLoader, LocalPullToRefresh provides customPullToRefresh,
        LocalFeeds provides provideFeeds
    ) {
        RestaurantNavScreenTest(restaurantId = 234) // 정보 탭, 메뉴 탭, 갤러리 탭, 리뷰 탭 내비게이션
//        RestaurantDetailNavigationScreen_(restaurantId = 234) // 정보, 지도 내비게이션
//        RestaurantGalleryScreen_(restaurantId = 234)
//        RestaurantMenuScreen_(restaurantId = 234)
//        PreviewRestaurantMenuColumn()
//        PreviewRestaurantMenuColumn1()
    }
}

val customPullToRefresh: PullToRefresh = { isRefreshing, onRefresh, contents ->
    contents.invoke()
}

@Composable
fun RestaurantGalleryScreen_(restaurantId: Int = 234) {
    RestaurantGalleryScreen(restaurantId = restaurantId)
}

@Composable
fun RestaurantMenuScreen_(restaurantId: Int = 234) {
    RestaurantMenuScreen(restaurantId = restaurantId, columnCount = 3)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantNavScreenTest(restaurantId : Int = 12, progressTintColor: Color? = null) {
    val context = LocalContext.current

    RestaurantNavScreen(
        restaurantId = restaurantId,
        progressTintColor = progressTintColor,
    )

}

@Preview
@Composable
fun PreviewRestaurantMenuColumn1() {
    RestaurantMenuColumn(
        //@formatter:off
        menus = listOf(
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_728.jpg", menuName = "hanburgerhanburgerhanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_740.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_753.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_765.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_782.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_792.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_801.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_812.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_822.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_20_923.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_36_394.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_36_404.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_53_226.jpg", menuName = "hanburger", price = 12000f),
        ),
        columnCount = 3,
        isSmallMenuItem = true,
        //@formatter:on
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFeed() {
    Box {
        Feed(
            review = Review.empty().copy(
                user = User.empty().copy(
                    name = "sryang",
                    profilePictureUrl = "http://sarang628.iptime.org:89/profile_images/9/2024-08-15/11_29_36_270.jpg"
                ),
                rating = 4.0f,
                reviewImages = listOf("http://sarang628.iptime.org:89/review_images/1/217/2024-08-24/05_17_33_823.jpg"),
                contents = "abc"
            ), imageLoadCompose = provideTorangAsyncImage1()
        )
    }
}
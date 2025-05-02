package com.sarang.torang

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.sarang.torang.compose.feed.Feed
import com.sarang.torang.compose.restaurant.RestaurantNavScreen
import com.sarang.torang.compose.restaurant.detail.RestaurantDetailNavigationScreen
import com.sarang.torang.compose.restaurant.detail.RestaurantInfo
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuColumn
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sarang.torang.data.basefeed.Restaurant
import com.sarang.torang.data.basefeed.Review
import com.sarang.torang.data.basefeed.User
import com.sarang.torang.data.restaurant.testMenuData
import com.sarang.torang.data.restaurant.testRestaurantInfo1
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sarang.torang.di.image.provideTorangAsyncImage1
import com.sryang.library.ExpandableText
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

@Composable
fun Main() {
    //RestaurantNavScreenTest_() // 정보 탭, 메뉴 탭, 갤러리 탭, 리뷰 탭 내비게이션
    RestaurantDetailNavigationScreen_() // 정보, 지도 내비게이션
    //RestaurantInfo_() // 정보
    //RestaurantGalleryScreen_()
    //PreviewRestaurantInfoScreen_()
    //RestaurantMenuScreen_()
    //PreviewRestaurantMenuColumn()
    //PreviewRestaurantMenuColumn1()
}

@Composable
fun RestaurantInfo_() {
    RestaurantInfo(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        restaurantInfoData = testRestaurantInfo1(),
        imageLoader = provideTorangAsyncImage()
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RestaurantDetailNavigationScreen_() {
    RestaurantDetailNavigationScreen(
        restaurantId = 234, imageLoader = provideTorangAsyncImage(),
        feed = {
            Feed(
                review = Review.empty().copy(
                    user = User.empty()
                        .copy(name = it.name, profilePictureUrl = it.profilePictureUrl),
                    rating = 4.0f,
                    reviewImages = it.reviewImages,
                    contents = it.contents,
                    restaurant = Restaurant(it.restaurantId, it.restaurantName)
                ),
                imageLoadCompose = provideTorangAsyncImage1(),
                expandableText = { modifier, a, b, c -> ExpandableText(modifier, a, b, c) })
        },
    )
}

@Composable
fun RestaurantGalleryScreen_() {
    RestaurantGalleryScreen(restaurantId = 6)
}

@Composable
fun RestaurantMenuScreen_() {
    RestaurantMenuScreen(restaurantId = 6, imageLoader = provideTorangAsyncImage(), columnCount = 3)
}

@Composable
fun RestaurantNavScreenTest_() {
    val context = LocalContext.current
    RestaurantNavScreenTest(
        onCall = { context.startActivity(Intent(Intent.ACTION_DIAL).apply { setData("tel:$it".toUri()) }) },
        progressTintColor = Color.Yellow
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantNavScreenTest(onCall: ((String) -> Unit)? = null, progressTintColor: Color? = null) {
    val context = LocalContext.current
    RestaurantNavScreen(
        restaurantId = 12,
        progressTintColor = progressTintColor,
        feeds = { reviewId, modifier ->
            Box {
                /*Feeds(
                    onRefresh = { },
                    onBottom = {},
                    isRefreshing = false,
                )*/
            }
        },
        onCall = {
            Toast.makeText(context, "call:${it}", Toast.LENGTH_SHORT).show()
            onCall?.invoke(it)
        },
        imageLoader = provideTorangAsyncImage(),
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
        imageLoader = provideTorangAsyncImage()
        //@formatter:on
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFeed(){
    Box{
        Feed(review = Review.empty().copy(user = User.empty().copy(name = "sryang", profilePictureUrl = "http://sarang628.iptime.org:89/profile_images/9/2024-08-15/11_29_36_270.jpg"), rating = 4.0f, reviewImages = listOf("http://sarang628.iptime.org:89/review_images/1/217/2024-08-24/05_17_33_823.jpg"), contents = "abc"), imageLoadCompose = provideTorangAsyncImage1())
    }
}
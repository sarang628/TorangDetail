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
import com.sarang.torang.compose.restaurant.RestaurantNavScreen
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.info.RestaurantDetailNavigationScreen
import com.sarang.torang.compose.restaurant.info.RestaurantInfo
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuColumn
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sarang.torang.data.restaurant.testMenuData
import com.sarang.torang.data.restaurant.testRestaurantInfo1
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
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background, content = { Main() } )
            }
        }
    }
}
//@formatter:on

@Composable
fun Main() {
    //Restaurant_()
    RestaurantDetailNavigationScreen_()
    //RestaurantInfo_()
    //RestaurantGalleryScreen_()
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
    RestaurantDetailNavigationScreen(restaurantId = 12, imageLoader = provideTorangAsyncImage())
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
fun Restaurant_() {
    val context = LocalContext.current
    Restaurant(
        onCall = { context.startActivity(Intent(Intent.ACTION_DIAL).apply { setData("tel:$it".toUri()) }) },
        progressTintColor = Color.Yellow
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Restaurant(onCall: ((String) -> Unit)? = null, progressTintColor: Color? = null) {
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
        map = null,
        onCall = {
            Toast.makeText(context, "call:${it}", Toast.LENGTH_SHORT).show()
            onCall?.invoke(it)
        },
        imageLoader = provideTorangAsyncImage(),
        onImage = {},
        onBack = {},
        onProfile = {},
        onContents = {}
    )
}

@Preview
@Composable
fun PreviewRestaurantMenuColumn1() {
    RestaurantMenuColumn(
        //@formatter:off
        menus = listOf(
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburgerhanburgerhanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/RedDot_Burger.jpg/500px-RedDot_Burger.jpg", menuName = "hanburger", price = 12000f),
        ),
        columnCount = 3,
        isSmallMenuItem = true,
        imageLoader = provideTorangAsyncImage()
        //@formatter:on
    )
}
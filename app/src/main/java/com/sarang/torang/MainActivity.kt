package com.sarang.torang

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.sarang.torang.compose.restaurant.RestaurantNavScreen
import com.sarang.torang.compose.restaurant.info.RestaurantInfo
import com.sarang.torang.data.restaurant.HoursOfOperation
import com.sarang.torang.data.restaurant.RestaurantInfo
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    RestaurantGalleryScreen(restaurantId = 6)
//                    RestaurantInfoScreen(restaurantId = 6)
//                    RestaurantMenuScreen(restaurantId = 6)
                    Restaurant(onCall = {
                        startActivity(
                            Intent(Intent.ACTION_DIAL).apply {
                                setData(Uri.parse("tel:$it"))
                            }
                        )
                    }, progressTintColor = Color.Yellow)
                }
            }
        }
    }
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
        image = provideTorangAsyncImage(),
        onImage = {},
        onBack = {},
        onProfile = {},
        onContents = {}
    )
}

@ThemePreviews
@Composable
fun PreviewRestaurantInfo1() {
    val restaurantInfoData = RestaurantInfo(
        foodType = "fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood",
        distance = "100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = "서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000",
        webSite = "https://torang.co.korea",
        tel = "02-1234-5678",
        hoursOfOperation = ArrayList<HoursOfOperation>().apply {
            add(HoursOfOperation("mon", "10:00", "22:00"))
            add(HoursOfOperation("tue", "10:00", "22:00"))
            add(HoursOfOperation("wed", "10:00", "22:00"))
            add(HoursOfOperation("thu", "10:00", "22:00"))
            add(HoursOfOperation("fri", "10:00", "22:00"))
            add(HoursOfOperation("sat", "10:00", "22:00"))
            add(HoursOfOperation("sun", "10:00", "22:00"))
        },
        price = "$$$$$ aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        rating = 4.5f,
        reviewCount = 100,
        imageUrl = "",
        name = "맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드"
    )
    TorangTheme {
        RestaurantInfo(/*Preview*/
            restaurantInfoData = restaurantInfoData,
            progressTintColor = Color.Yellow
        )
    }
}
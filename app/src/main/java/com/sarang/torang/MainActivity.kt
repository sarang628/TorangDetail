package com.sarang.torang

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.samples.apps.sunflower.ui.TorangTheme
import com.sarang.torang.compose.restaurant.RestaurantNavScreen
import com.sarang.torang.compose.restaurant.gallery.RestaurantGalleryScreen
import com.sarang.torang.compose.restaurant.info.RestaurantInfo
import com.sarang.torang.compose.restaurant.info.RestaurantInfoScreen
import com.sarang.torang.compose.restaurant.menu.RestaurantMenuScreen
import com.sarang.torang.data.restaurant.HoursOfOperation
import com.sarang.torang.data.restaurant.RestaurantInfo
import com.sryang.library.compose.SimplePermissionDialog
import com.sryang.torang.compose.feed.Feeds
import com.sryang.torang.uistate.FeedsUiState
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
                    })
                }
            }
        }
    }
}

@Composable
fun Restaurant(onCall: ((String) -> Unit)? = null) {
    val context = LocalContext.current
    RestaurantNavScreen(
        restaurantId = 6,
        feeds = {
            Box {
                Feeds(
                    onRefresh = { },
                    onBottom = {},
                    isRefreshing = false,
                    ratingBar = { _, _ -> },
                    FeedsUiState.Success(ArrayList())
                )
            }
        },
        map = null,
        onCall = {
            Toast.makeText(context, "call:${it}", Toast.LENGTH_SHORT).show()
            onCall?.invoke(it)
        }
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
            restaurantInfoData = restaurantInfoData
        )
    }
}
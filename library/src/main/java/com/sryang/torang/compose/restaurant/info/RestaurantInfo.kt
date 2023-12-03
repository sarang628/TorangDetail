package com.sryang.torang.compose.restaurant.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.library.RatingBar
import com.sryang.torang.R
import com.sryang.torang.data.restaurant.RestaurantInfo
import com.sryang.torang.data.restaurant.operationTime


@Composable
fun RestaurantInfo(
    restaurantInfoData: RestaurantInfo
) {
    Column(Modifier.fillMaxWidth()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = restaurantInfoData.imageUrl,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Column(
                    Modifier
                        .background(Color(0x55000000))
                        .padding(8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = restaurantInfoData.name,
                        fontSize = 25.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Row {
                        Text(
                            text = restaurantInfoData.rating.toString(),
                            fontSize = 25.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        RatingBar(rating = restaurantInfoData.rating)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "(${restaurantInfoData.reviewCount})",
                            color = MaterialTheme.colorScheme.primaryContainer
                        )
                    }
                }
            }
        }

        Column {
            Row(Modifier.padding(top = 15.dp, bottom = 15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_loc), contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 20.dp)
                        .size(20.dp)
                )
                Column {
                    Row {
                        Text(text = restaurantInfoData.foodType)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = restaurantInfoData.distance)
                    }
                    Text(text = restaurantInfoData.price)
                }

            }
        }


        Text(
            text = "",
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
        Row(Modifier.padding(top = 15.dp, bottom = 15.dp)) {
            restaurantInfoData.address.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_loc), contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 20.dp)
                        .size(20.dp)
                )
                Text(text = it)
            }
        }
        Text(
            text = "",
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )

        Row(Modifier.padding(top = 15.dp, bottom = 15.dp)) {
            restaurantInfoData.webSite.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_site), contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 20.dp)
                        .size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = it)
            }
        }

        Text(
            text = "",
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )

        Row(Modifier.padding(top = 15.dp, bottom = 15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_time), contentDescription = "",
                modifier = Modifier
                    .padding(start = 10.dp, end = 20.dp)
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = restaurantInfoData.operationTime)
        }

        Text(
            text = "",
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )

        Row(Modifier.padding(top = 15.dp, bottom = 15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_suggest), contentDescription = "",
                modifier = Modifier
                    .padding(start = 10.dp, end = 20.dp)
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = restaurantInfoData.tel)
        }

        Text(
            text = "",
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}

@Preview
@Composable
fun PreviewRestaurantInfo() {
    val restaurantInfoData = RestaurantInfo(
        foodType = "패스트푸드점",
        distance = "100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = "서울특별시 강남구 삼성동 삼성로 3000",
        webSite = "https://torang.co.korea",
        tel = "02-1234-5678",
        hoursOfOperation = ArrayList(),
        price = "",
        rating = 4.5f,
        reviewCount = 100,
        imageUrl = "",
        name = "맥도날드"
    )
    RestaurantInfo(
        restaurantInfoData = restaurantInfoData
    )
}

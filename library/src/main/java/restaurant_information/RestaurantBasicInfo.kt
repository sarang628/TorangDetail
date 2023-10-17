package restaurant_information

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.library.RatingBar
import com.example.torang_detail.R
import data.RestaurantInfoData
import data.operationTime

@Composable
fun RestaurantBasicInfo(
    restaurantInfoData: RestaurantInfoData,
    restaurantImageUrl: String
) {
    Column(Modifier.fillMaxWidth()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0x11000000))
                .height(200.dp)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = restaurantImageUrl + restaurantInfoData.imageUrl,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = restaurantInfoData.name ?: "",
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp, bottom = 8.dp),
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Column(Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 12.dp)) {
            Row {
                Text(text = "4.3")
                Spacer(modifier = Modifier.width(5.dp))
                RatingBar(rating = 4.3f)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "(650)")
            }

            Row {
                restaurantInfoData.foodType?.let { Text(text = it) }
                Spacer(modifier = Modifier.width(5.dp))
                restaurantInfoData.distance?.let { Text(text = it) }
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "$$$")
            }
            Row {
                restaurantInfoData.open?.let { Text(text = it) }
                restaurantInfoData.close?.let { Text(text = it) }
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
            restaurantInfoData.address?.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_loc), contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 20.dp)
                        .size(20.dp)
                )
                Text(text = "주소")
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
            restaurantInfoData.webSite?.let {
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
            restaurantInfoData.webSite?.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_time), contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 20.dp)
                        .size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = restaurantInfoData.operationTime)
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
            restaurantInfoData.tel?.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_suggest), contentDescription = "",
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
    }
}

@Preview
@Composable
fun PreviewRestaurantInfo() {
    val restaurantInfoData = RestaurantInfoData(
        foodType = "패스트푸드점",
        distance = "100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = "서울특별시 강남구 삼성동 삼성로 3000",
        webSite = "https://torang.co.korea",
        tel = "02-1234-5678",
        hoursOfOperation = ArrayList()
    )
    RestaurantBasicInfo(
        restaurantInfoData = restaurantInfoData,
        restaurantImageUrl = ""
    )
}

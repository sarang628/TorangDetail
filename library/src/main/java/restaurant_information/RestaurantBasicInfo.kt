package restaurant_information

import data.RestaurantInfoData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantBasicInfo(restaurantInfoData: RestaurantInfoData) {
    Column(Modifier.fillMaxWidth()) {
        Row {
            restaurantInfoData.foodType?.let { Text(text = it) }
            restaurantInfoData.distance?.let { Text(text = it) }
        }
        Row {
            restaurantInfoData.open?.let { Text(text = it) }
            restaurantInfoData.close?.let { Text(text = it) }
        }

        Row {
            restaurantInfoData.address?.let {
                Text(text = "주소")
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = it)
            }
        }

        Row {
            restaurantInfoData.webSite?.let {
                Text(text = "사이트")
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = it)
            }
        }

        Row {
            restaurantInfoData.number?.let {
                Text(text = "전화번호")
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = it)
            }
        }
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
        number = "02-1234-5678"
    )
    RestaurantBasicInfo(restaurantInfoData = restaurantInfoData)
}

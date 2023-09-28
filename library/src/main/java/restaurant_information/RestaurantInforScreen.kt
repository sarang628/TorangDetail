package restaurant_information

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.library.RatingBar
import com.example.torang_detail.R
import data.MenuData
import data.RestaurantInfoData
import data.ReviewRowData
import data.ReviewSummaryData


@Composable
fun RestaurantInfoScreen(
    restaurantId: Int,
    viewModel: RestaurantInfoViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        Column(Modifier.padding(start = 8.dp, end = 8.dp)) {
            // 레스토랑 기본정보
            RestaurantBasicInfo(restaurantInfoData = uiState.restaurantInfoData)
            Spacer(modifier = Modifier.height(8.dp))
            // 레스토랑 이미지
            RestaurantImages(list = uiState.restaurantImage)
            Spacer(modifier = Modifier.height(8.dp))
            // 레스토랑 메뉴
            RestaurantMenus(menus = uiState.menus)
            Spacer(modifier = Modifier.height(8.dp))
            // 레스토랑 리뷰요약
            RestaurantReviewSummary(uiState.reviewSummaryData)
            Spacer(modifier = Modifier.height(8.dp))
            // 레스토랑 리뷰
            RestaurantReviews(uiState.reviewRowData)
        }

        uiState.errorMessage?.let { errorMessage ->
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                buttons = {
                    Button(onClick = {
                        viewModel.clearErrorMessage()
                    }) {
                        androidx.compose.material.Text(text = "Confirm")
                    }
                },
                title = { androidx.compose.material.Text(text = errorMessage) }
            )
        }
    }
}

@Composable
fun RatingInfo(rating: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = rating.toString())
        RatingBar(rating = rating)
    }
}

@Preview
@Composable
fun PreviewRatingInfo() {
    RatingInfo(rating = 3.0f)
}

@Composable
fun RestaurantInfoTitle(title: String) {
    Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
}

@Preview
@Composable
fun RestaurantInfoData() {
    RestaurantInfoTitle(title = "메뉴 타이틀")
}

@Preview
@Composable
fun PreviewRestaurantInformation() {
    val a = RestaurantInfoData(
        foodType = "패스트푸드점",
        distance = "100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = "서울특별시 강남구 삼성동 삼성로 3000",
        webSite = "https://torang.co.korea",
        number = "02-1234-5678"
    )

    val b = ArrayList<ReviewRowData>()
        .apply {
            add(
                ReviewRowData(
                    name = "JM",
                    fullName = "강아지",
                    rating = 3.0f,
                    comment = "서비스가 훌륭함"
                )
            )
            add(ReviewRowData(name = "DY", fullName = "대한민국", rating = 3.0f, comment = "맛있음"))
            add(ReviewRowData(name = "CA", fullName = "희망찬", rating = 3.0f, comment = "저렴함"))
            add(ReviewRowData(name = "OY", fullName = "고양이", rating = 3.0f, comment = "가까움"))
        }

    val c = ArrayList<MenuData>().apply {
        add(MenuData(menuName = "스테이크", price = 30000f))
        add(MenuData(menuName = "파스타", price = 300000f))
        add(MenuData(menuName = "커피", price = 300000f))
        add(MenuData(menuName = "디저트", price = 300000f))
        add(MenuData(menuName = "와인", price = 300000f))
        add(MenuData(menuName = "에피타이저", price = 300000f))
        add(MenuData(menuName = "샐러드", price = 300000f))
    }

    val d = ArrayList<RestaurantImage>().apply {
        add(RestaurantImage(url = "http://sarang628.iptime.org:88/restaurants/2.jpeg"))
        add(RestaurantImage(url = "http://sarang628.iptime.org:88/restaurants/2-1.jpeg"))
        add(RestaurantImage(url = "http://sarang628.iptime.org:88/restaurants/1.jpeg"))
        add(RestaurantImage(url = "http://sarang628.iptime.org:88/restaurants/1-1.jpeg"))
    }

}
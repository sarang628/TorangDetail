package restaurant_information

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import data.RestaurantImage
import data.RestaurantInfoData
import data.ReviewRowData


@Composable
fun RestaurantInfoScreen(
    viewModel: RestaurantInfoViewModel,
    reviewImageUrl : String,
    restaurantImageUrl : String
) {
    val uiState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        LazyColumn(content = {
            items(5) {
                if (it == 0) {
                    // 레스토랑 기본정보
                    RestaurantBasicInfo(
                        restaurantInfoData = uiState.restaurantInfoData,
                        restaurantImageUrl = restaurantImageUrl
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                } else if (it == 1) {
                    // 레스토랑 이미지
                    RestaurantImages(url = reviewImageUrl, list = uiState.restaurantImage)
                    Spacer(modifier = Modifier.height(8.dp))
                } else if (it == 2) {
                    // 레스토랑 메뉴
                    RestaurantMenus(menus = uiState.menus)
                    Spacer(modifier = Modifier.height(8.dp))
                } else if (it == 3) {
                    // 레스토랑 리뷰요약
                    RestaurantReviewSummary(uiState.reviewSummaryData)
                    Spacer(modifier = Modifier.height(8.dp))
                } else if (it == 4) {
                    // 레스토랑 리뷰
                    RestaurantReviews(uiState.reviewRowData)
                }
            }
        })

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
fun RestaurantInfoTitle() {
    RestaurantInfoTitle(title = "메뉴 타이틀")
}

@Preview
@Composable
fun PreviewRestaurantInformation() {
}
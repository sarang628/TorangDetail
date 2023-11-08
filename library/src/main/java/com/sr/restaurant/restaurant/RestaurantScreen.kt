package com.sr.restaurant.restaurant

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.library.RatingBar
import com.sr.restaurant.restaurant.compose.basic.RestaurantBasicInfo
import com.sr.restaurant.restaurant.compose.basic.RestaurantImages
import com.sr.restaurant.restaurant.compose.basic.RestaurantMenus
import com.sr.restaurant.restaurant.compose.basic.RestaurantReviewSummary
import com.sr.restaurant.restaurant.compose.basic.RestaurantReviews
import com.sr.restaurant.restaurant.viewmodel.RestaurantInfoUIState


@Composable
fun RestaurantScreen(
    uiState: RestaurantInfoUIState,
    reviewImageUrl: String,
    restaurantImageUrl: String,
    onClearErrorMessage: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
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
                confirmButton = {
                    Button(onClick = {
                        onClearErrorMessage.invoke()
                    }) {
                        Text(text = "Confirm")
                    }
                },
                title = { Text(text = errorMessage) }
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
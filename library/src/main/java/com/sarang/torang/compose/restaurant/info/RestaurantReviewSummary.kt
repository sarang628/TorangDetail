package com.sarang.torang.compose.restaurant.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.library.RatingBar
import com.sryang.torang.data.restaurant.ReviewSummaryData

@Composable
fun RestaurantReviewSummary(data: ReviewSummaryData) {
    Column(Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)) {
        RestaurantInfoTitle(title = "Summery")
        Row(Modifier.height(80.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = data.rating.toString(), fontSize = 30.sp)
                RatingBar(rating = data.rating)
                Text(text = "(${data.totalReviewer})")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                LinearProgressIndicator(data.score5, Modifier.fillMaxWidth())
                LinearProgressIndicator(data.score4, Modifier.fillMaxWidth())
                LinearProgressIndicator(data.score3, Modifier.fillMaxWidth())
                LinearProgressIndicator(data.score2, Modifier.fillMaxWidth())
                LinearProgressIndicator(data.score1, Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview
@Composable
fun PreviewReviewSummary() {
    RestaurantReviewSummary(
        data = ReviewSummaryData(
            rating = 4.0f,
            totalReviewer = 300,
            score5 = 1.0f,
            score4 = 0.8f,
            score3 = 0.6f,
            score2 = 0.4f,
            score1 = 0.2f
        )
    )
}
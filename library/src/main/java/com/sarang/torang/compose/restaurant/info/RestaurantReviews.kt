package com.sarang.torang.compose.restaurant.info

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.data.restaurant.ReviewRowData
import com.sarang.torang.widgets.RatingBar

@Composable
fun RestaurantReviews(reviewRowData: List<ReviewRowData>?) {
    if (!reviewRowData.isNullOrEmpty()) {
        Column(Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)) {
            RestaurantInfoTitle("Review")
            Spacer(modifier = Modifier.height(8.dp))
            for (reviewData in reviewRowData) {
                ReviewRow(
                    name = reviewData.name,
                    fullName = reviewData.fullName,
                    rating = reviewData.rating,
                    comment = reviewData.comment
                )
            }
        }
    }
}

class MenuDate(manuName: String, price: String)

@Preview
@Composable
fun PreviewReviews() {
    val reviews = ArrayList<ReviewRowData>()
        .apply {
            add(ReviewRowData(name = "JM", fullName = "강아지", rating = 3.0f, comment = "서비스가 훌륭함"))
            add(ReviewRowData(name = "DY", fullName = "대한민국", rating = 3.0f, comment = "맛있음"))
            add(ReviewRowData(name = "CA", fullName = "희망찬", rating = 3.0f, comment = "저렴함"))
            add(ReviewRowData(name = "OY", fullName = "고양이", rating = 3.0f, comment = "가까움"))
        }
    RestaurantReviews(reviews)
}

@Composable
fun ReviewRow(name: String, fullName: String, rating: Float, comment: String) {
    Row {
        Box(modifier = Modifier.size(35.dp), contentAlignment = Alignment.Center) {
            Button(onClick = { }, modifier = Modifier.size(35.dp)) {}
            Text(
                text = if (name.length > 2) name.substring(0, 2) else name,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row {
                Text(text = fullName)
                RatingBar(rating = rating)
                Text(text = rating.toString())
            }
            Text(text = comment, maxLines = 3, overflow = TextOverflow.Ellipsis)
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}
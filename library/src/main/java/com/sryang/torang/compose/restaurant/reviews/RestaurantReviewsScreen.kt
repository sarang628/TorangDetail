package com.sryang.torang.compose.restaurant.reviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.library.RatingBar

@Preview
@Composable
fun RestaurantReviewScreen() {
    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn(content = {
            items(100) {
                ItemReview()
            }
        })
    }
}

@Preview
@Composable
fun ItemReview() {
    Column {
        Row(Modifier.height(60.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = "http://sarang628.iptime.org:89/5.png",
                contentDescription = "",
                Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column {
                Text(text = "JANG Ace")
                Row {
                    Text(text = "Local Guide")
                    Text(text = "58 reviews")
                }
            }
        }

        Column(Modifier.height(60.dp), verticalArrangement = Arrangement.Center) {
            Row {
                RatingBar(rating = 3.5f)
                Text(text = "2 month ago")
            }
            Row {
                Text(text = "Dine in")
                Text(text = "|")
                Text(text = "Dinner")
                Text(text = "|")
                Text(text = "$10-20")

            }
        }

        Text(text = "맛있었습니다.", modifier = Modifier.padding(bottom = 10.dp))

        Row {
            AsyncImage(
                model = "http://sarang628.iptime.org:89/review_images/1/1/2023-09-11/10_38_05_627.jpeg",
                contentDescription = "",
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(1.dp),
                contentScale = ContentScale.Crop
            )
            AsyncImage(
                model = "http://sarang628.iptime.org:89/review_images/1/1/2023-09-11/10_38_05_627.jpeg",
                contentDescription = "",
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(1.dp),
                contentScale = ContentScale.Crop
            )
        }
        Row {
            AsyncImage(
                model = "http://sarang628.iptime.org:89/review_images/1/1/2023-09-11/10_38_05_627.jpeg",
                contentDescription = "",
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(1.dp),
                contentScale = ContentScale.Crop
            )
            AsyncImage(
                model = "http://sarang628.iptime.org:89/review_images/1/1/2023-09-11/10_38_05_627.jpeg",
                contentDescription = "",
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(1.dp),
                contentScale = ContentScale.Crop
            )
        }

    }


}

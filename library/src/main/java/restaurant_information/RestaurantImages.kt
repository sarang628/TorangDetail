package restaurant_information

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import data.RestaurantImage

@Composable
fun RestaurantImages(url: String, list: List<RestaurantImage>? = null) {
    if (!list.isNullOrEmpty()) {
        Box(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
        ) {
            LazyRow {
                items(list, itemContent = {
                    Box {
                        AsyncImage(
                            model = url + it.url,
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                })
            }
        }
    }
}

@Preview
@Composable
fun PreviewRestaurantImages() {
    RestaurantImages(url = "", ArrayList<RestaurantImage>().apply {
        add(RestaurantImage(url = "http://sarang628.iptime.org:89/restaurants/2.jpeg"))
        add(RestaurantImage(url = "http://sarang628.iptime.org:89/restaurants/2-1.jpeg"))
        add(RestaurantImage(url = "http://sarang628.iptime.org:89/restaurants/1.jpeg"))
        add(RestaurantImage(url = "http://sarang628.iptime.org:89/restaurants/1-1.jpeg"))
    })
}

package restaurant_information

import RestaurantInfoData
import ReviewRowData
import ReviewSummaryData
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.library.RatingBar
import com.example.torang_detail.R


@Composable
fun RestaurantInformation(
    rating: Float? = null,
    restaurantInfoData: RestaurantInfoData? = null,
    reviewRowData: List<ReviewRowData>? = null,
    reviewSummaryData: ReviewSummaryData? = null,
    menus: List<MenuData>? = null
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        Column(Modifier.padding(start = 8.dp, end = 8.dp)) {
            rating?.let {
                RatingInfo(it)
            }
            restaurantInfoData?.let {
                RestaurantInfo(restaurantInfoData = it)
            }
            Spacer(modifier = Modifier.height(8.dp))
            RestaurantImages()
            Spacer(modifier = Modifier.height(8.dp))
            menus?.let {
                Menus(it)
            }
            Spacer(modifier = Modifier.height(8.dp))
            reviewSummaryData?.let {
                ReviewSummary(it)
            }
            Spacer(modifier = Modifier.height(8.dp))
            reviewRowData?.let {
                Reviews(it)
            }
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
    RestaurantInformation(
        //rating = 3.5f,
        //restaurantInfoData = RestaurantInfoData(),
        reviewRowData = null,
        reviewSummaryData = null,
        menus = null
    )
}
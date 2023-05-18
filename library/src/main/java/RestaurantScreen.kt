import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun RestaurantScreen() {
    val navController = rememberNavController()
    Column {
        Row {
            Button(onClick = { navController.navigate("info") }) {
                Text(text = "정보")
            }
            Button(onClick = { navController.navigate("menu") }) {
                Text(text = "메뉴")
            }
            Button(onClick = { navController.navigate("review") }) {
                Text(text = "리뷰")
            }
            Button(onClick = { navController.navigate("gallery") }) {
                Text(text = "사진")
            }
        }
        NavHost(navController = navController, startDestination = "info") {
            composable("info") {
                RestaurantInformation()
            }
            composable("menu") {
                RestaurantMenu()
            }
            composable("review") {
                RestaurantReview()
            }
            composable("gallery") {
                RestaurantGallery()
            }
        }
    }
}

@Preview
@Composable
fun RestaurantInformation() {
    Column {
        Text(text = "레스토랑", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Row {
            Text(text = "4.0")
            Text(text = "RatingBar")
        }
        Row {
            Text(text = "패스트푸드점")
            Text(text = "100m")
        }
        Row {
            Text(text = "영업 중")
            Text(text = "오후 9:00에 영업 종료")
        }
    }
}

@Preview
@Composable
fun RestaurantMenu() {
    Text(text = "메뉴")
}

@Preview
@Composable
fun RestaurantReview() {
    Text(text = "리뷰")
}

@Preview
@Composable
fun RestaurantGallery() {
    Text(text = "사진")
}
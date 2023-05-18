import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.library.RatingBar
import com.example.torang_detail.R

@Preview
@Composable
fun RestaurantScreen() {
    val navController = rememberNavController()
    Column {
        RestaurntTopMenu(navController)
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
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        Text(text = "레스토랑", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Row {
            Text(text = "4.0")
            RatingBar(rating = 3.5f)
        }
        Row {
            Text(text = "패스트푸드점")
            Text(text = "100m")
        }
        Row {
            Text(text = "영업 중")
            Text(text = "오후 9:00에 영업 종료")
        }

        Row {
            Text(text = "주소")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "서울특별시 강남구 삼성동 삼성로 3000")
        }

        Row {
            Text(text = "사이트")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "https://torang.co.korea")
        }

        Row {
            Text(text = "전화번호")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "02-1234-5678")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            Text(text = "메뉴", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row {
                Row(Modifier.weight(1f)) {
                    Text(text = "스테이크")
                    Text(text = "30000원")
                }
                Row(Modifier.weight(1f)) {
                    Text(text = "파스타")
                    Text(text = "30000원")
                }
            }

            Row {
                Row(Modifier.weight(1f)) {
                    Text(text = "커피")
                    Text(text = "30000원")
                }
                Row(Modifier.weight(1f)) {
                    Text(text = "디저트")
                    Text(text = "30000원")
                }
            }

            Row {
                Row(Modifier.weight(1f)) {
                    Text(text = "와인")
                    Text(text = "30000원")
                }
                Row(Modifier.weight(1f)) {
                    Text(text = "에피타이저")
                    Text(text = "30000원")
                }
            }
            Row {
                Row(Modifier.weight(1f)) {
                    Text(text = "샐러드")
                    Text(text = "30000원")
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            Text(text = "리뷰", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }

            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
            Column {
                Row {
                    Text(text = "누구")
                    RatingBar(rating = 3.5f)
                    Text(text = "3.5")
                }
                Text(text = "맛있네요")
            }
        }
    }
}

@Preview
@Composable
fun RestaurantMenu() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        Text(text = "메뉴")
    }
}

@Preview
@Composable
fun RestaurantReview() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        Text(text = "리뷰")
    }
}

@Preview
@Composable
fun RestaurantGallery() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        Text(text = "사진")
    }
}

@Composable
fun RestaurntTopMenu(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val tabContents = listOf(
        "정보" to Icons.Filled.Home,
        "메뉴" to Icons.Filled.AddCircle,
        "리뷰" to Icons.Filled.Settings,
        "사진" to Icons.Filled.Settings
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.colorSecondaryLight),
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 2.dp
    ) {
        tabContents.forEachIndexed { index, pair: Pair<String, ImageVector> ->
            BottomNavigationItem(
                icon = { Icon(pair.second, contentDescription = null) },
                label = { androidx.compose.material.Text(pair.first) },
                selected = selectedIndex == index,
                alwaysShowLabel = false, // Hides the title for the unselected items
                onClick = {
                    selectedIndex = index
                    if (index == 0) {
                        navController.navigate("info")
                    } else if (index == 1) {
                        navController.navigate("menu")
                    } else if (index == 2) {
                        navController.navigate("review")
                    } else {
                        navController.navigate("gallery")
                    }
                }
            )
        }
    }
}
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.library.RatingBar
import com.example.torang_detail.R

@Preview
@Composable
fun RestaurantInformation() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        Column(
            Modifier
                .padding(start = 8.dp, end = 8.dp)

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

            Box(Modifier.height(150.dp)) {
                LazyRow {
                    item {
                        AsyncImage(
                            model = "http://sarang628.iptime.org:88/restaurants/2.jpeg",
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        AsyncImage(
                            model = "http://sarang628.iptime.org:88/restaurants/2-1.jpeg",
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        AsyncImage(
                            model = "http://sarang628.iptime.org:88/restaurants/1.jpeg",
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        AsyncImage(
                            model = "http://sarang628.iptime.org:88/restaurants/1-1.jpeg",
                            contentDescription = "",
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column {
                Text(text = "메뉴", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Row(Modifier.weight(1f)) {
                        Text(text = "스테이크")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "30000원")
                    }
                    Row(Modifier.weight(1f)) {
                        Text(text = "파스타")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "30000원")
                    }
                }

                Row {
                    Row(Modifier.weight(1f)) {
                        Text(text = "커피")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "30000원")
                    }
                    Row(Modifier.weight(1f)) {
                        Text(text = "디저트")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "30000원")
                    }
                }

                Row {
                    Row(Modifier.weight(1f)) {
                        Text(text = "와인")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "30000원")
                    }
                    Row(Modifier.weight(1f)) {
                        Text(text = "에피타이저")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "30000원")
                    }
                }
                Row {
                    Row(Modifier.weight(1f)) {
                        Text(text = "샐러드")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "30000원")
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column {
                Text(text = "리뷰", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                ReviewRow(name = "JM", fullName = "강아지", rating = 3.0f, comment = "서비스가 훌륭함")
                ReviewRow(name = "DY", fullName = "대한민국", rating = 3.0f, comment = "맛있음")
                ReviewRow(name = "CA", fullName = "희망찬", rating = 3.0f, comment = "저렴함")
                ReviewRow(name = "OY", fullName = "고양이", rating = 3.0f, comment = "가까움")
            }
        }
    }
}


@Composable
fun ReviewRow(name: String, fullName: String, rating: Float, comment: String) {
    Row {
        Box(modifier = Modifier.size(35.dp), contentAlignment = Alignment.Center) {
            Button(onClick = { }, modifier = Modifier.size(35.dp)) {

            }
            Text(
                text = name,
                color = Color.White,
                fontSize = 15.sp,
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
            Text(text = comment)
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}
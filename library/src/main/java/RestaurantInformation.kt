import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

            Row {
                AsyncImage(
                    model = "",
                    contentDescription = "",
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
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
}
package com.sarang.torang.compose.restaurant.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.sarang.torang.R
import com.sarang.torang.data.restaurant.HoursOfOperation
import com.sarang.torang.data.restaurant.RestaurantInfo
import com.sarang.torang.data.restaurant.operationTime
import com.sarang.torang.widgets.RatingBar


@Composable
fun RestaurantInfo(
    restaurantInfoData: RestaurantInfo,
    onLocation: (() -> Unit)? = null,
    onWeb: (() -> Unit)? = null,
    onCall: (() -> Unit)? = null,
) {
    ConstraintLayout(constraintSet = restauarntInfoConstraintSet()) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .layoutId("img"),
            model = restaurantInfoData.imageUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        RestaurantTitleAnd(
            modifier = Modifier.layoutId("restaurantTitleBox"),
            restaurantName = restaurantInfoData.name,
            rating = restaurantInfoData.rating,
            reviewCount = restaurantInfoData.reviewCount
        )

        Image(
            painter = painterResource(id = R.drawable.ic_info), contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .padding(15.dp)
                .layoutId("icInfo")
        )
        Text(text = restaurantInfoData.foodType, modifier = Modifier.layoutId("foodType"))
        Text(text = restaurantInfoData.distance, modifier = Modifier.layoutId("distance"))
        Text(text = restaurantInfoData.price, modifier = Modifier.layoutId("price"))
        HorizontalDivider(Modifier.layoutId("foodTypeDivider"))

        Row(Modifier.layoutId("icLoc")) {
            IconButton(onClick = { onLocation?.invoke() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_loc),
                    contentDescription = "",
                    modifier = Modifier.size(21.dp)
                )
            }

            Text(
                text = restaurantInfoData.address,
                Modifier
                    .layoutId("address")
                    .padding(top = 5.dp, bottom = 5.dp)
                    .clickable {
                        onLocation?.invoke()
                    }
            )
        }
        HorizontalDivider(Modifier.layoutId("locDivider"))

        IconButton(onClick = { onWeb?.invoke() }, modifier = Modifier.layoutId("icSite")) {
            Icon(
                painter = painterResource(id = R.drawable.ic_web),
                contentDescription = "",
                modifier = Modifier.size(21.dp)
            )
        }
        Text(text = restaurantInfoData.webSite, modifier = Modifier
            .layoutId("webSite")
            .clickable {
                onWeb?.invoke()
            })

        HorizontalDivider(Modifier.layoutId("siteDivider"))

        Row(Modifier.layoutId("icTime"), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_time), contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .padding(15.dp)
            )

            Text(
                text = restaurantInfoData.operationTime,
                modifier = Modifier
                    .layoutId("operationTime")
                    .padding(top = 5.dp, bottom = 5.dp)
            )
        }
        HorizontalDivider(Modifier.layoutId("timeDivider"))

        IconButton(onClick = { onCall?.invoke() }, modifier = Modifier.layoutId("icTel")) {
            Icon(
                painter = painterResource(id = R.drawable.ic_phone),
                contentDescription = "",
                modifier = Modifier.size(21.dp)
            )
        }

        Text(text = restaurantInfoData.tel, modifier = Modifier
            .layoutId("tel")
            .clickable {
                onCall?.invoke()
            })

        HorizontalDivider(Modifier.layoutId("telDivider"))
    }
}

fun restauarntInfoConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val img = createRefFor("img")
        val restaurantTitleBox = createRefFor("restaurantTitleBox")
        val icInfo = createRefFor("icInfo")
        val foodType = createRefFor("foodType")
        val distance = createRefFor("distance")
        val price = createRefFor("price")
        val foodTypeDivider = createRefFor("foodTypeDivider")

        val icLoc = createRefFor("icLoc")
        val address = createRefFor("address")
        val locDivider = createRefFor("locDivider")
        val icSite = createRefFor("icSite")
        val webSite = createRefFor("webSite")
        val siteDivider = createRefFor("siteDivider")

        val icTime = createRefFor("icTime")
        val operationTime = createRefFor("operationTime")
        val timeDivider = createRefFor("timeDivider")

        val icTel = createRefFor("icTel")
        val tel = createRefFor("tel")
        val telDivider = createRefFor("telDivider")


        constrain(restaurantTitleBox) {
            bottom.linkTo(img.bottom)
            end.linkTo(img.end)
        }

        constrain(icInfo) {
            top.linkTo(img.bottom, margin = 5.dp)
        }

        constrain(foodType) {
            top.linkTo(icInfo.top)
            bottom.linkTo(icInfo.bottom)
            start.linkTo(icInfo.end)
        }

        constrain(distance) {
            top.linkTo(icInfo.top)
            bottom.linkTo(icInfo.bottom)
            start.linkTo(foodType.end, margin = 5.dp)
        }

        constrain(price) {
            top.linkTo(icInfo.top)
            bottom.linkTo(icInfo.bottom)
            start.linkTo(distance.end, margin = 5.dp)
        }

        constrain(foodTypeDivider) {
            top.linkTo(icInfo.bottom)
        }

        constrain(foodTypeDivider) {
            top.linkTo(icInfo.bottom)
        }

        constrain(icLoc) {
            top.linkTo(foodTypeDivider.bottom)
        }

        constrain(address) {
            top.linkTo(icLoc.top)
            bottom.linkTo(icLoc.bottom)
            start.linkTo(icLoc.end)
            end.linkTo(parent.end, margin = 5.dp)
            width = Dimension.fillToConstraints
        }

        constrain(locDivider) {
            top.linkTo(icLoc.bottom)
        }

        constrain(icSite) {
            top.linkTo(locDivider.bottom)
        }

        constrain(webSite) {
            top.linkTo(icSite.top)
            bottom.linkTo(icSite.bottom)
            start.linkTo(icInfo.end)
        }

        constrain(siteDivider) {
            top.linkTo(icSite.bottom)
        }

        constrain(icTime) {
            top.linkTo(siteDivider.bottom)
        }

        constrain(operationTime) {
            top.linkTo(icTime.top)
            start.linkTo(icInfo.end)
        }

        constrain(timeDivider) {
            top.linkTo(icTime.bottom)
        }

        constrain(icTel) {
            top.linkTo(timeDivider.bottom)
        }
        constrain(tel) {
            top.linkTo(icTel.top)
            bottom.linkTo(icTel.bottom)
            start.linkTo(icTel.end)
        }
        constrain(telDivider) {
            top.linkTo(icTel.bottom)
        }
    }
}


@Composable
fun RestaurantTitleAnd(
    modifier: Modifier = Modifier,
    restaurantName: String,
    rating: Float,
    reviewCount: Int,
) {
    Box(
        modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            Modifier
                .background(Color(0x55000000))
                .padding(8.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = restaurantName,
                maxLines = 1,
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(
                    text = rating.toString(),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(5.dp))
                RatingBar(rating = rating)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "(${reviewCount})",
                    color = MaterialTheme.colorScheme.primaryContainer
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRestaurantInfo() {
    val restaurantInfoData = RestaurantInfo(
        foodType = "fastfood",
        distance = "100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = "서울특별시 강남구 삼성동 삼성로 3000",
        webSite = "https://torang.co.korea",
        tel = "02-1234-5678",
        hoursOfOperation = ArrayList<HoursOfOperation>().apply {
            add(HoursOfOperation("mon", "10:00", "22:00"))
            add(HoursOfOperation("tue", "10:00", "22:00"))
            add(HoursOfOperation("wed", "10:00", "22:00"))
            add(HoursOfOperation("thu", "10:00", "22:00"))
            add(HoursOfOperation("fri", "10:00", "22:00"))
            add(HoursOfOperation("sat", "10:00", "22:00"))
            add(HoursOfOperation("sun", "10:00", "22:00"))
        },
        price = "$$$",
        rating = 4.5f,
        reviewCount = 100,
        imageUrl = "",
        name = "맥도날드"
    )
    RestaurantInfo(
        restaurantInfoData = restaurantInfoData
    )
}

@Preview
@Composable
fun PreviewRestaurantInfo1() {
    val restaurantInfoData = RestaurantInfo(
        foodType = "fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood",
        distance = "100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = "서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000",
        webSite = "https://torang.co.korea",
        tel = "02-1234-5678",
        hoursOfOperation = ArrayList<HoursOfOperation>().apply {
            add(HoursOfOperation("mon", "10:00", "22:00"))
            add(HoursOfOperation("tue", "10:00", "22:00"))
            add(HoursOfOperation("wed", "10:00", "22:00"))
            add(HoursOfOperation("thu", "10:00", "22:00"))
            add(HoursOfOperation("fri", "10:00", "22:00"))
            add(HoursOfOperation("sat", "10:00", "22:00"))
            add(HoursOfOperation("sun", "10:00", "22:00"))
        },
        price = "$$$$$ aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        rating = 4.5f,
        reviewCount = 100,
        imageUrl = "",
        name = "맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드"
    )
    RestaurantInfo(
        restaurantInfoData = restaurantInfoData
    )
}

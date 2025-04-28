package com.sarang.torang.compose.restaurant.info

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.sarang.torang.R
import com.sarang.torang.data.restaurant.HoursOfOperation
import com.sarang.torang.data.restaurant.RestaurantInfoData
import com.sarang.torang.data.restaurant.operationTime


@Composable
fun RestaurantInfo(
    modifier: Modifier = Modifier,
    restaurantInfoData: RestaurantInfoData = RestaurantInfoData(),
    onLocation: () -> Unit = { },
    onWeb: () -> Unit = { },
    onCall: () -> Unit = { },
    progressTintColor: Color? = null,
    imageLoader : @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = {_,_,_,_,_->}
) {
    //@formatter:off
    ConstraintLayout(modifier = modifier, constraintSet = restaurantInfoConstraintSet()) {
        Box                 (modifier = Modifier.layoutId("img").fillMaxWidth().height(300.dp)){ imageLoader.invoke  (Modifier.fillMaxSize(), restaurantInfoData.imageUrl, null, null, ContentScale.Crop) }
        RestaurantTitleAnd  (modifier = Modifier.layoutId("restaurantTitleBox"), restaurantName = restaurantInfoData.name, rating = restaurantInfoData.rating, reviewCount = restaurantInfoData.reviewCount, progressTintColor = progressTintColor)
        Icon                (modifier = Modifier.layoutId("icInfo").size(50.dp).padding(15.dp), painter = painterResource(id = R.drawable.ic_info), contentDescription = "")
        Text                (modifier = Modifier.layoutId("foodType"), text = "${restaurantInfoData.foodType} ${restaurantInfoData.distance} ${restaurantInfoData.price}")
        Text                (modifier = Modifier.layoutId("webSite").clickable { onWeb.invoke() }, text = restaurantInfoData.webSite)
        Text                (modifier = Modifier.layoutId("tel").clickable { onCall.invoke() }, text = restaurantInfoData.tel)
        Text                (modifier = Modifier.layoutId("address").padding(top = 5.dp, bottom = 5.dp).clickable { onLocation.invoke() }, text = restaurantInfoData.address)
        Text                (modifier = Modifier.layoutId("hoursOfOperation").padding(top = 5.dp, bottom = 5.dp), text = restaurantInfoData.operationTime)
        IconButton          (modifier = Modifier.layoutId("icSite"), onClick = onWeb) { Icon(painter = painterResource(id = R.drawable.ic_web), contentDescription = "", modifier = Modifier.size(21.dp)) }
        IconButton          (modifier = Modifier.layoutId("icTel"), onClick = onCall) { Icon(modifier = Modifier.size(21.dp), painter = painterResource(id = R.drawable.ic_phone), contentDescription = "") }
        HorizontalDivider   (modifier = Modifier.layoutId("foodTypeCenter").size(0.dp))
        HorizontalDivider   (modifier = Modifier.layoutId("addressCenter").size(0.dp))
        HorizontalDivider   (modifier = Modifier.layoutId("websiteCenter").size(0.dp))
        HorizontalDivider   (modifier = Modifier.layoutId("telCenter").size(0.dp))
        HorizontalDivider   (modifier = Modifier.layoutId("foodTypeDivider"))
        HorizontalDivider   (modifier = Modifier.layoutId("locDivider"))
        HorizontalDivider   (modifier = Modifier.layoutId("siteDivider"))
        HorizontalDivider   (modifier = Modifier.layoutId("timeDivider"))
        HorizontalDivider   (modifier = Modifier.layoutId("telDivider"))
        IconButton          (modifier = Modifier.layoutId("icLoc"), onClick = onLocation) { Icon(painter = painterResource(id = R.drawable.ic_loc), contentDescription = "", modifier = Modifier.size(21.dp)) }
        Icon                (modifier = Modifier.layoutId("icTime").size(50.dp).padding(15.dp), painter = painterResource(id = R.drawable.ic_time), contentDescription = "")
    //@formatter:on
    }
}

fun restaurantInfoConstraintSet(): ConstraintSet {
    //@formatter:off
    return ConstraintSet {
        val guideline = createGuidelineFromEnd(10.dp)

        val img                     = createRefFor("img")
        val restaurantTitleBox      = createRefFor("restaurantTitleBox")
        val icInfo                  = createRefFor("icInfo")
        val icLoc                   = createRefFor("icLoc")
        val icSite                  = createRefFor("icSite")
        val icTel                   = createRefFor("icTel")
        val icTime                  = createRefFor("icTime")
        val foodType                = createRefFor("foodType")
        val foodTypeCenter          = createRefFor("foodTypeCenter")
        val addressCenter           = createRefFor("addressCenter")
        val websiteCenter           = createRefFor("websiteCenter")
        val telCenter               = createRefFor("tenCenter")
        val timeCenter              = createRefFor("timeCenter")
        val foodTypeDivider         = createRefFor("foodTypeDivider")
        val locDivider              = createRefFor("locDivider")
        val siteDivider             = createRefFor("siteDivider")
        val timeDivider             = createRefFor("timeDivider")
        val address                 = createRefFor("address")
        val webSite                 = createRefFor("webSite")
        val tel                     = createRefFor("tel")
        val hoursOfOperation        = createRefFor("hoursOfOperation")
        val telDivider              = createRefFor("telDivider")
        val footTypeBarrier         = createBottomBarrier(icInfo, foodType)
        val addressBarrier          = createBottomBarrier(icLoc, address)
        val webSiteBarrier          = createBottomBarrier(icSite, webSite)
        val timeBarrier             = createBottomBarrier(icTime, hoursOfOperation)
        val telBarrier             = createBottomBarrier(icTel, tel)

        constrain(restaurantTitleBox)   { bottom.linkTo(img.bottom);end.linkTo(img.end); }
        constrain(foodType)             { top.linkTo(foodTypeCenter.bottom, margin = (-8).dp); start.linkTo(icInfo.end); end.linkTo(guideline); width = Dimension.fillToConstraints }
        constrain(icInfo)               { top.linkTo(img.bottom, margin = 5.dp) }
        constrain(icLoc)                { top.linkTo(foodTypeDivider.bottom) }
        constrain(icSite)               { top.linkTo(locDivider.bottom) }
        constrain(icTime)               { top.linkTo(siteDivider.bottom) }
        constrain(icTel)                { top.linkTo(timeDivider.bottom) }
        constrain(foodTypeCenter)       { top.linkTo(icInfo.top); bottom.linkTo(icInfo.bottom); }
        constrain(addressCenter)        { top.linkTo(icLoc.top); bottom.linkTo(icLoc.bottom); }
        constrain(websiteCenter)        { top.linkTo(icSite.top); bottom.linkTo(icSite.bottom); }
        constrain(timeCenter)           { top.linkTo(icTime.top); bottom.linkTo(icTime.bottom); }
        constrain(telCenter)            { top.linkTo(icTel.top); bottom.linkTo(icTel.bottom); }
        constrain(address)              { top.linkTo(addressCenter.bottom, margin = (-16).dp);start.linkTo(icLoc.end);end.linkTo(parent.end, margin = 5.dp);width = Dimension.fillToConstraints }
        constrain(webSite)              { top.linkTo(websiteCenter.top, (-8).dp);start.linkTo(icInfo.end) }
        constrain(tel)                  { top.linkTo(telCenter.bottom, (-8).dp);start.linkTo(icTel.end) }
        constrain(hoursOfOperation)     { top.linkTo(timeCenter.top, (-16).dp);start.linkTo(icTel.end) }
        constrain(foodTypeDivider)      { top.linkTo(footTypeBarrier) }
        constrain(locDivider)           { top.linkTo(addressBarrier) }
        constrain(siteDivider)          { top.linkTo(webSiteBarrier) }
        constrain(timeDivider)          { top.linkTo(timeBarrier) }
        constrain(telDivider)           { top.linkTo(telBarrier) }
        //@formatter:on
    }
}


@Composable
fun RestaurantTitleAnd(
    modifier: Modifier = Modifier,
    restaurantName: String = "",
    rating: Float = 0f,
    reviewCount: Int = 0,
    progressTintColor: Color? = null,
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = rating.toString(),
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(5.dp))
                AndroidViewRatingBar(
                    rating = rating,
                    progressTintColor = progressTintColor,
                    changable = false,
                    isSmall = true
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "(${reviewCount})",
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRestaurantTitleAnd() {
    RestaurantTitleAnd()
}

@Preview
@Composable
fun PreviewRestaurantInfo() {
    val restaurantInfoData = RestaurantInfoData(
        foodType = "fastfood",
        distance = "100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = "서울특별시 강남구 삼성동 삼성로 3000",
        webSite = "https://torang.co.korea",
        tel = "02-1234-5678",
        hoursOfOperation = ArrayList<HoursOfOperation>().apply {
//            add(HoursOfOperation("mon", "10:00", "22:00"))
//            add(HoursOfOperation("tue", "10:00", "22:00"))
//            add(HoursOfOperation("wed", "10:00", "22:00"))
//            add(HoursOfOperation("thu", "10:00", "22:00"))
//            add(HoursOfOperation("fri", "10:00", "22:00"))
//            add(HoursOfOperation("sat", "10:00", "22:00"))
//            add(HoursOfOperation("sun", "10:00", "22:00"))
        },
        price = "$$$",
        rating = 4.5f,
        reviewCount = 100,
        imageUrl = "",
        name = "맥도날드"
    )
    RestaurantInfo(restaurantInfoData = restaurantInfoData)
}

@Preview
@Composable
fun PreviewRestaurantInfo1() {
    val restaurantInfoData = RestaurantInfoData(
//        foodType = "fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfoodfastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood fastfood",
        foodType = "fastfood",
//        distance = "100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m 100m",
//        open = "영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중영업 중",
//        close = "오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료오후 9:00에 영업 종료",
//        address = "서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000 서울특별시 강남구 삼성동 삼성로 3000",
        address = "삼성로 3000",
//        webSite = "https://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.koreahttps://torang.co.korea",
        webSite = "https://torang.co.korea",
        tel = "02-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-567802-1234-5678",
        hoursOfOperation = ArrayList<HoursOfOperation>().apply {
            add(HoursOfOperation("mon", "10:00", "22:00"))
            add(HoursOfOperation("tue", "10:00", "22:00"))
            add(HoursOfOperation("wed", "10:00", "22:00"))
            add(HoursOfOperation("thu", "10:00", "22:00"))
            add(HoursOfOperation("fri", "10:00", "22:00"))
            add(HoursOfOperation("sat", "10:00", "22:00"))
            add(HoursOfOperation("sun", "10:00", "22:00"))
        },
//        price = "$$$$$ aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        rating = 4.5f,
        reviewCount = 100,
        imageUrl = "",
//        name = "맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드맥도날드"
    )
    RestaurantInfo(restaurantInfoData = restaurantInfoData)
}

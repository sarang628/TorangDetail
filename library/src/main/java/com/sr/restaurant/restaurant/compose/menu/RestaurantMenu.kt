package com.sr.restaurant.restaurant.compose.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.library.RatingBar
import com.example.torang_detail.R
import com.sr.restaurant.restaurant.data.MenuData

@Composable
fun RestaurantMenu(
    list: List<MenuData>,
    menuImageServerUrl: String
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
            items(list.size) {
                var menu = list[it]
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(start = 2.dp, end = 2.dp, top = 2.dp, bottom = 2.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = menuImageServerUrl + menu.url,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 8.dp, bottom = 8.dp)
                    ) {
                        Text(
                            text = menu.menuName,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        RatingBar(rating = 3.0f)
                        Text(
                            text = menu.price.toString(),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        })
    }
}
package com.sr.restaurant.restaurant.compose.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.torang_detail.R
import com.sr.restaurant.restaurant.data.RestaurantImage


@Composable
fun RestaurantGallery(
    list: List<RestaurantImage>,
    reviewImageUrl : String
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(150.dp), content = {
            items(list.size) {
                AsyncImage(
                    modifier = Modifier.padding(1.dp),
                    model = reviewImageUrl + list[it].url,
                    contentDescription = ""
                )
            }
        })
    }
}
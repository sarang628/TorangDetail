package com.sarang.torang.compose.restaurant

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun RestaurantList() {
    Column(Modifier.fillMaxSize()) {
        Text("Restaurant List", fontSize = 20.sp)
        LazyColumn {
            items(30) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Button(onClick = {}) {
                            Text("Restaurant")
                        }
                    }
                }
            }
        }
    }
}
package com.sr.restaurant.restaurant.compose.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sr.restaurant.restaurant.data.MenuData

@Composable
fun RestaurantMenus(menus: List<MenuData>?) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        if (!menus.isNullOrEmpty()) {
            RestaurantInfoTitle("Menu")
            Spacer(modifier = Modifier.height(8.dp))
            for (i in 0 until menus.size) {
                RestaurantMenu(
                    menuData1 = menus[i]
                )
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(top = 3.dp, bottom = 3.dp)
                        .padding(top = 3.dp, bottom = 3.dp)
                )
            }
        }
    }
}

@Composable
fun RestaurantMenu(menuData1: MenuData) {
    Row {
        Row(Modifier.weight(1f)) {
            Text(text = menuData1.menuName + "..." + menuData1.price.toString())
        }
    }
}

@Preview
@Composable
fun PreviewMenus() {
    RestaurantMenus(menus = ArrayList<MenuData>().apply {
        add(
            MenuData(
                menuName = "스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크스테이크",
                price = 30000f,
                url = ""
            )
        )
        add(MenuData(menuName = "파스타", price = 300000f, url = ""))
        add(MenuData(menuName = "커피", price = 300000f, url = ""))
        add(MenuData(menuName = "디저트", price = 300000f, url = ""))
        add(MenuData(menuName = "와인", price = 300000f, url = ""))
        add(MenuData(menuName = "에피타이저", price = 300000f, url = ""))
        add(MenuData(menuName = "샐러드", price = 300000f, url = ""))
    })

}
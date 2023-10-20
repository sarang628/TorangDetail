package com.sr.restaurant.restaurant.compose.basic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sr.restaurant.restaurant.RestaurantInfoTitle
import com.sr.restaurant.restaurant.data.MenuData

@Composable
fun RestaurantMenus(menus: List<MenuData>?) {
    Column(Modifier.fillMaxWidth()) {
        if (!menus.isNullOrEmpty()) {
            RestaurantInfoTitle("메뉴")
            Spacer(modifier = Modifier.height(8.dp))
            for (i in 0 until menus.size) {
                RestaurantMenu(
                    menuData1 = menus[i],
                    menuData2 = menus[i]
                )
            }
        }
    }
}

@Composable
fun RestaurantMenu(menuData1: MenuData, menuData2: MenuData?) {
    Row {
        Row(Modifier.weight(1f)) {
            Text(text = menuData1.menuName)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "...")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = menuData1.price.toString())
        }

        menuData2?.let {
            Row(Modifier.weight(1f)) {
                Text(text = it.menuName)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "...")
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = it.price.toString())
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenus() {
    RestaurantMenus(menus = ArrayList<MenuData>().apply {
        add(MenuData(menuName = "스테이크", price = 30000f, url = ""))
        add(MenuData(menuName = "파스타", price = 300000f, url = ""))
        add(MenuData(menuName = "커피", price = 300000f, url = ""))
        add(MenuData(menuName = "디저트", price = 300000f, url = ""))
        add(MenuData(menuName = "와인", price = 300000f, url = ""))
        add(MenuData(menuName = "에피타이저", price = 300000f, url = ""))
        add(MenuData(menuName = "샐러드", price = 300000f, url = ""))
    })

}
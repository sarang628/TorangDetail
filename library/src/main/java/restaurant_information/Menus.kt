package restaurant_information

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

@Composable
fun Menus(menus: List<MenuData>) {
    Column(Modifier.fillMaxWidth()) {
        RestaurantInfoTitle("메뉴")
        Spacer(modifier = Modifier.height(8.dp))
        for (i in 0..menus.size / 2) {
            Menu(
                menuData1 = menus[i * 2],
                menuData2 = if (i * 2 + 1 >= menus.size) null else menus[i * 2 + 1]
            )
        }
    }
}

@Composable
fun Menu(menuData1: MenuData, menuData2: MenuData?) {
    Row {
        Row(Modifier.weight(1f)) {
            Text(text = menuData1.menuName)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = menuData1.price.toString())
        }

        menuData2?.let {
            Row(Modifier.weight(1f)) {
                Text(text = it.menuName)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = it.price.toString())
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenus() {
    Menus(menus = ArrayList<MenuData>().apply {
        add(MenuData(menuName = "스테이크", price = 30000f))
        add(MenuData(menuName = "파스타", price = 300000f))
        add(MenuData(menuName = "커피", price = 300000f))
        add(MenuData(menuName = "디저트", price = 300000f))
        add(MenuData(menuName = "와인", price = 300000f))
        add(MenuData(menuName = "에피타이저", price = 300000f))
        add(MenuData(menuName = "샐러드", price = 300000f))
    })

}
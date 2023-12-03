package com.sryang.torang.data.restaurant

data class MenuData(val menuName: String, val price: Float, val url: String)

fun testMenuData(): MenuData {
    return MenuData(
        menuName = "menuName",
        price = 10000.0f,
        url = ""
    )
}
package data

data class MenuData(val menuName: String, val price: Float)

fun testMenuData(): MenuData {
    return MenuData(
        menuName = "menuName",
        price = 10000.0f
    )
}
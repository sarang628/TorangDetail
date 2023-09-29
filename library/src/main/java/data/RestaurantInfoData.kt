package data

data class RestaurantInfoData(
    val foodType: String? = null,
    val distance: String? = null,
    val open: String? = null,
    val close: String? = null,
    val address: String? = null,
    val webSite: String? = null,
    val tel: String? = null,
    val imageUrl: String? = null,
    val name: String? = null,
)

fun testRestaurantInfoData(): RestaurantInfoData {
    return RestaurantInfoData(
        foodType = "foodType",
        distance = "distance",
        open = "open",
        close = "close",
        address = "address",
        webSite = "webSite",
        tel = "number",
        name = "restaurant",
        imageUrl = "1/1/2023-09-11/10_37_55_147.jpeg"
    )

}
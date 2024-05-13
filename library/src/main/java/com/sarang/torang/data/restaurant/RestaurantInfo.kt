package com.sarang.torang.data.restaurant

data class RestaurantInfo(
    val foodType: String = "",
    val distance: String = "",
    val open: String = "",
    val close: String = "",
    val address: String = "",
    val webSite: String = "",
    val tel: String = "",
    val imageUrl: String = "",
    val name: String = "",
    val hoursOfOperation: List<HoursOfOperation> = arrayListOf(),
    val rating: Float = 0.0f,
    val price: String = "",
    val reviewCount: Int = 0,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
)

fun testRestaurantInfo(): RestaurantInfo {
    return RestaurantInfo(
        foodType = "foodType",
        distance = "distance",
        open = "open",
        close = "close",
        address = "address",
        webSite = "webSite",
        tel = "number",
        name = "restaurant",
        imageUrl = "1/1/2023-09-11/10_37_55_147.jpeg",
        hoursOfOperation = ArrayList(),
        rating = 0.0f,
        reviewCount = 10,
        price = "@@"
    )

}

val RestaurantInfo.operationTime: String
    get() = toHoursOperation()


fun RestaurantInfo.toHoursOperation(): String {
    var str = ""
    this.hoursOfOperation?.let {
        it.forEach {
            str += it.day + " " + it.startTime + " - " + it.endTime
            if (it.day != this.hoursOfOperation.get(this.hoursOfOperation.size - 1).day)
                str += "\n"
        }
    }
    return str
}
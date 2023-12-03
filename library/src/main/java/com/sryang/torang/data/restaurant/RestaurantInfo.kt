package com.sryang.torang.data.restaurant

data class RestaurantInfoData(
    val foodType: String,
    val distance: String,
    val open: String,
    val close: String,
    val address: String,
    val webSite: String,
    val tel: String,
    val imageUrl: String,
    val name: String,
    val hoursOfOperation: List<HoursOfOperation>,
    val rating: Float,
    val price: String,
    val reviewCount: Int
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
        imageUrl = "1/1/2023-09-11/10_37_55_147.jpeg",
        hoursOfOperation = ArrayList(),
        rating = 0.0f,
        reviewCount = 10,
        price = "@@"
    )

}

val RestaurantInfoData.operationTime: String
    get() = toHoursOperation()


fun RestaurantInfoData.toHoursOperation(): String {
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
package com.sr.restaurant.restaurant.data

import android.text.TextUtils

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
    val hoursOfOperation: List<HoursOfOperation>? = null
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
        hoursOfOperation = ArrayList()
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
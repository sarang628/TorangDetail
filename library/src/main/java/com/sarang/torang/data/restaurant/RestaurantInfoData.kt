package com.sarang.torang.data.restaurant

data class RestaurantInfoData(
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

fun testRestaurantInfo(): RestaurantInfoData = RestaurantInfoData(
    foodType = "foodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodTypefoodType",
    distance = "distancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistancedistance",
    open = "openopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopenopen",
    close = "closeclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclosecloseclose",
    address = "addressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddressaddress",
    webSite = "webSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSitewebSite",
    tel = "numbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumbernumber",
    name = "restaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurantrestaurant",
    imageUrl = "1/1/2023-09-11/10_37_55_147.jpeg",
    hoursOfOperation = ArrayList(),
    rating = 0.0f,
    reviewCount = 10,
    price = "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
)

fun testRestaurantInfo1(): RestaurantInfoData = RestaurantInfoData(
    foodType = "Korean",
    distance = "250m",
    open = "open",
    close = "close",
    address = "300 Olympic-ro, Songpa District, Seoul",
    webSite = "google.com",
    tel = "02-3213-5000",
    name = "P.F. Chang's",
    imageUrl = "http://sarang628.iptime.org:89/restaurant_images/209/2024-08-14/11_25_09_492.jpg",
    hoursOfOperation = listOf(
        HoursOfOperation("Mon", "10:00", "20:00"),
        HoursOfOperation("Tue", "10:00", "20:00"),
        HoursOfOperation("Wed", "10:00", "20:00"),
        HoursOfOperation("Thu", "10:00", "20:00"),
        HoursOfOperation("Fri", "10:00", "20:00"),
        HoursOfOperation("Sat", "10:00", "20:00"),
        HoursOfOperation("Sun", "10:00", "20:00"),
    ),
    rating = 4.0f,
    reviewCount = 10,
    price = "$$"
)

val RestaurantInfoData.operationTime: String
    get() = toHoursOperation()


fun RestaurantInfoData.toHoursOperation(): String {
    var str = ""
    this.hoursOfOperation.let {
        it.forEach {
            str += it.day + " " + it.startTime + " - " + it.endTime
            if (it.day != this.hoursOfOperation.get(this.hoursOfOperation.size - 1).day)
                str += "\n"
        }
    }
    return str
}

fun RestaurantInfoData.toDayOfOperation(): String {
    var str = ""
    this.hoursOfOperation.let {
        it.forEach {
            str += it.day
            if (it.day != this.hoursOfOperation.get(this.hoursOfOperation.size - 1).day)
                str += "\n"
        }
    }
    return str
}

fun RestaurantInfoData.toHoursOfOperation(): String {
    var str = ""
    this.hoursOfOperation.let {
        it.forEach {
            str += it.startTime + " - " + it.endTime
            if (it.day != this.hoursOfOperation.get(this.hoursOfOperation.size - 1).day)
                str += "\n"
        }
    }
    return str
}
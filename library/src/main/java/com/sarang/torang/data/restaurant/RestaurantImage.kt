package com.sarang.torang.data.restaurant

data class RestaurantImage(
    val url: String
)

fun testRestaurantImage(): RestaurantImage {
    return RestaurantImage(url = "http://sarang628.iptime.org:89/restaurants/2.jpeg")
}
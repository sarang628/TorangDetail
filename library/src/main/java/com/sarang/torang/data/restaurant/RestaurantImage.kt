package com.sarang.torang.data.restaurant

data class RestaurantImage(
    val id : Int,
    val url: String
)

fun testRestaurantImage(): RestaurantImage {
    return RestaurantImage(id = 2, url = "http://sarang628.iptime.org:89/restaurants/2.jpeg")
}
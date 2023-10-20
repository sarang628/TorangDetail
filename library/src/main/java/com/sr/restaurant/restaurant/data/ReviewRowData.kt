package com.sr.restaurant.restaurant.data

data class ReviewRowData(
    val name: String,
    val fullName: String,
    val rating: Float,
    val comment: String
)

fun testReviewRowData(): ReviewRowData {
    return ReviewRowData(name = "name", fullName = "fullName", rating = 3.5f, comment = "comment")
}
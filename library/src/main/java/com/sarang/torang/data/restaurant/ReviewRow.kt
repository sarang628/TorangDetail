package com.sarang.torang.data.restaurant

data class ReviewRowData(
    val name: String,
    val fullName: String,
    val rating: Float,
    val comment: String,
    val userId : Int,
    val reviewId : Int
)

fun testReviewRowData(): ReviewRowData {
    return ReviewRowData(name = "name", fullName = "fullName", rating = 3.5f, comment = "comment", reviewId = 0, userId = 0)
}
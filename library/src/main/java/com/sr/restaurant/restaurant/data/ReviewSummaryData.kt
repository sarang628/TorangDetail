package com.sr.restaurant.restaurant.data

data class ReviewSummaryData(
    val rating: Float,
    val totalReviewer: Int,
    val score5: Float,
    val score4: Float,
    val score3: Float,
    val score2: Float,
    val score1: Float,
)

fun testReviewSummaryData(): ReviewSummaryData {
    return ReviewSummaryData(
        rating = 3.5f,
        totalReviewer = 10,
        score5 = 5.0f,
        score4 = 4.0f,
        score3 = 3.0f,
        score2 = 2.0f,
        score1 = 1.0f
    )
}
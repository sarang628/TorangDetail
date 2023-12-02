package com.example.myapplication.di.restaurant_detail

import android.util.Log
import com.sr.restaurant.restaurant.data.FeedData
import com.sr.restaurant.restaurant.data.HoursOfOperation
import com.sr.restaurant.restaurant.data.MenuData
import com.sr.restaurant.restaurant.data.RestaurantImage
import com.sr.restaurant.restaurant.data.RestaurantInfoData
import com.sr.restaurant.restaurant.data.ReviewRowData
import com.sr.restaurant.restaurant.data.ReviewSummaryData
import com.sr.restaurant.restaurant.usecase.RestaurantInfoService
import com.sr.restaurant.restaurant.viewmodel.RestaurantInfoUIState
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.api.ApiReview
import com.sryang.torang_repository.data.RestaurantDetail
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.HttpException

@InstallIn(SingletonComponent::class)
@Module
class RestaurantServiceModule {
    @Provides
    fun provideRestaruantService(
        apiRestaurant: ApiRestaurant,
        apiReview: ApiReview
    ): RestaurantInfoService {
        return object : RestaurantInfoService {
            override suspend fun loadRestaurant(restaurantId: Int): RestaurantInfoUIState {
                try {
                    val result: RestaurantDetail = apiRestaurant.getRestaurantDetail(restaurantId)
                    return RestaurantInfoUIState(
                        restaurantInfoData = result.toRestaurantInfoData(),
                        menus = result.toMenus(),
                        restaurantImage = result.toRestaurantImages(),
                        reviewRowData = result.toReviewRowData(),
                        reviewSummaryData = result.toReviewSummaryData(),
                        reviews = ArrayList()
                    )

                } catch (e: HttpException) {
                    val message = e.errorMessage()
                    Log.e("RestaurantServiceModule", message)
                    throw Exception(message)
                } catch (e: Exception) {
                    Log.e("RestaurantServiceModule", e.toString())
                }
                throw Exception("알 수 없는 오류가 발생했습니다.")
            }

            override suspend fun loadReviews(restaurantId: Int): List<FeedData> {
                return apiReview.getReviews(restaurantId).map { it.toFeedData() }
            }
        }
    }
}

fun HttpException.errorMessage(): String {
    return this.response()?.errorBody()?.string() ?: "알 수 없는 오류가 발생했습니다."
}

fun RestaurantDetail.toRestaurantInfoData(): RestaurantInfoData {
    return RestaurantInfoData(
        foodType = this.restaurant.restaurantType,
        distance = "100m",
        open = "영업 중",
        close = "오후 9:00에 영업 종료",
        address = this.restaurant.address,
        webSite = this.restaurant.website,
        tel = this.restaurant.tel,
        name = this.restaurant.restaurantName,
        imageUrl = this.restaurant.imgUrl1,
        hoursOfOperation = this.hoursOfOperations.map { it.toHoursOfOperation() },
        rating = this.restaurant.rating,
        reviewCount = this.restaurant.reviewCount,
        price = this.restaurant.prices
    )
}

fun com.sryang.torang_repository.data.HoursOfOperation.toHoursOfOperation(): HoursOfOperation {
    return HoursOfOperation(
        day = this.day,
        startTime = this.start_time,
        endTime = this.end_time
    )
}

fun RestaurantDetail.toMenus(): List<MenuData> {
    return this.menus.map {
        MenuData(
            menuName = it.menu_name,
            price = it.menu_price.toFloat(),
            url = it.menu_pic_url
        )
    }
}

fun RestaurantDetail.toRestaurantImages(): List<RestaurantImage> {
    return this.pictures.map {
        RestaurantImage(
            url = it.picture_url
        )
    }
}

fun RestaurantDetail.toReviewSummaryData(): ReviewSummaryData {
    return ReviewSummaryData(
        rating = this.restaurant.rating,
        totalReviewer = this.restaurant.reviewCount,
        score5 = 5.0f,
        score4 = 4.0f,
        score3 = 3.0f,
        score2 = 2.0f,
        score1 = 1.0f
    )
}

fun RestaurantDetail.toReviewRowData(): List<ReviewRowData> {
    return this.comments.map {
        ReviewRowData(
            name = it.user_name,
            fullName = it.user_name,
            rating = 3.0f,
            comment = it.comment
        )
    }
}

fun RemoteFeed.toFeedData(): FeedData {
    return FeedData(
        reviewId = this.reviewId,
        userId = this.user.userId,
        name = this.user.userName,
        restaurantName = this.restaurant.restaurantName,
        rating = this.rating,
        profilePictureUrl = this.user.profilePicUrl,
        likeAmount = this.like_amount,
        commentAmount = this.comment_amount,
        author = "",
        author1 = "",
        author2 = "",
        comment = "",
        comment1 = "",
        comment2 = "",
        isLike = this.like != null,
        isFavorite = this.favorite != null,
        visibleLike = false,
        visibleComment = false,
        contents = this.contents,
        reviewImages = this.pictures.map { it.picture_url },
        restaurantId = this.restaurant.restaurantId
    )
}
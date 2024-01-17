package com.sarang.torang.di.restaurant_detail

import com.example.myapplication.BuildConfig
import com.sryang.torang.compose.restaurant.info.RestaurantImages
import com.sryang.torang.data.restaurant.Feed
import com.sryang.torang.data.restaurant.MenuData
import com.sryang.torang.data.restaurant.RestaurantImage
import com.sryang.torang.data.restaurant.RestaurantInfo
import com.sryang.torang.uistate.RestaurantInfoUIState
import com.sryang.torang.usecase.GetMenuUseCase
import com.sryang.torang.usecase.GetRestaurantGalleryUseCase
import com.sryang.torang.usecase.GetRestaurantInfoUseCase
import com.sryang.torang.usecase.RestaurantInfoService
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.api.ApiReview
import com.sryang.torang_repository.api.handle
import com.sryang.torang_repository.data.RestaurantDetail
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
                    val message = e.handle()
                    throw Exception(message)
                }
            }

            override suspend fun loadReviews(restaurantId: Int): List<Feed> {
                try {
                    return apiReview.getReviews(restaurantId).map { it.toFeedData() }
                } catch (e: HttpException) {
                    throw Exception(e.handle())
                }
            }
        }
    }

    @Provides
    fun providesGetRestaurantGalleryUseCase(
        apiRestaurant: ApiRestaurant
    ): GetRestaurantGalleryUseCase {
        return object : GetRestaurantGalleryUseCase {
            override suspend fun invoke(restaurantId: Int): List<RestaurantImage> {
                return apiRestaurant.getRestaurantDetail(restaurantId).toRestaurantImages()
            }
        }
    }

    @Provides
    fun providesGetRestaurantInfoUseCase(apiRestaurant: ApiRestaurant): GetRestaurantInfoUseCase {
        return object : GetRestaurantInfoUseCase {
            override suspend fun invoke(restaurantId: Int): RestaurantInfo {
                return apiRestaurant.getRestaurantDetail(restaurantId).toRestaurantInfoData()
            }
        }
    }

    @Provides
    fun providesGetMenuUseCase(apiRestaurant: ApiRestaurant): GetMenuUseCase {
        return object : GetMenuUseCase {
            override suspend fun invoke(restaurantId: Int): List<MenuData> {
                return apiRestaurant.getRestaurantDetail(restaurantId).toMenus()
            }
        }
    }
}
package com.sarang.torang

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.repository.RestaurantRepository
import com.sarang.torang.usecase.GetRestaurantInfoUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class GetRestaurantInfoUseCaseTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var getRestaurantInfoUseCase: GetRestaurantInfoUseCase

    @Inject
    lateinit var apiRestaurant : ApiRestaurant

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
    }

    @Test
    fun testGetRestaurantInfoUseCase() = runTest {
        val result = getRestaurantInfoUseCase.invoke(234)
        Log.i("__GetRestaurantInfoUseCaseTest","image url = ${result.imageUrl}")
        assert(result.imageUrl.isNotBlank())
    }

    @Test
    fun testGetRestaurantDetail() = runTest {
        val result = apiRestaurant.getRestaurantDetail(234)
        Log.i("__GetRestaurantInfoUseCaseTest","image url = ${result.restaurant.imgUrl1}")
        assert(result.restaurant.imgUrl1.isNotBlank())
    }
}
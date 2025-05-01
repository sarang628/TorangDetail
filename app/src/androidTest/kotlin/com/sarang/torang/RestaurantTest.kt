package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.api.ApiLogin
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.repository.RestaurantRepository
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
class RestaurantTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiLogin: ApiLogin

    @Inject
    lateinit var apiRestaurant: ApiRestaurant

    @Inject
    lateinit var restaurantRepository: RestaurantRepository

    var token = ""

    @Before
    fun setUp() = runTest {
        hiltRule.inject()
        //token = apiLogin.emailLogin("sry_ang@naver.com", Encrypt.encrypt("didtkfkd")).token
    }

    @Test
    fun testGetAlarms() = runTest {
        val result = apiRestaurant.getAllRestaurant()
        assert(!result.isEmpty())
    }

    @Test
    fun test() = runTest {

    }

}
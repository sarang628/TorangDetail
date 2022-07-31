package com.example.torang_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.torang_core.navigation.RestaurantDetailNavigation
import com.example.torang_detail.databinding.ActivityRestaurantDetailBinding
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

/**
 * [InfoFragment]
 * [PictureFragment]
 * [ReviewFragment]
 * [MenuRatingFragment]
 * [MyReviewFragment]
 */
@AndroidEntryPoint
class RestaurantDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityRestaurantDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setSupportActionBar(mBinding.toolbar3)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, RestaurantDetailFragment())
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun go(context: Context, restaurantId: Int) {
            context.startActivity(Intent(context, RestaurantDetailActivity::class.java).apply {
                putExtra("restaurantId", restaurantId)
            })
        }
    }
}

class RestaurantDetailNavigationImpl @Inject constructor() : RestaurantDetailNavigation {
    override fun go(context: Context, userId: Int) {
        RestaurantDetailActivity.go(context, userId)
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class TimeLineDetailNavigationInject {
    @Binds
    abstract fun bindTimeLineDetailNavigation(
        restaurantDetailNavigationImpl: RestaurantDetailNavigationImpl
    ): RestaurantDetailNavigation
}
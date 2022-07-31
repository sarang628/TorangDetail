package com.example.torang_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.torang_detail.databinding.FragmentRestaurantDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantDetailFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRestaurantDetailBinding.inflate(layoutInflater, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fc) as NavHostFragment
        navController = navHostFragment.navController

        binding.bn.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_info,
                R.id.nav_picture,
                R.id.nav_review,
                R.id.nav_menurating,
                R.id.nav_myreview
            )
        )
        NavigationUI.setupWithNavController(binding.tb, navController, appBarConfiguration)

        return binding.root
    }

    fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import restaurant_information.RestaurantInfoScreen
import restaurant_information.RestaurantInfoViewModel

@Composable
fun RestaurantScreen(
    restaurantId: Int,
    restaurantInfoViewModel: RestaurantInfoViewModel,
    reviewImageUrl: String,
    restaurantImageUrl: String
) {
    val navController = rememberNavController()
    restaurantInfoViewModel.loadRestaurant(restaurantId = restaurantId)
    Box {
        Column {
            RestaurntTopMenu(navController)
            NavHost(navController = navController, startDestination = "info") {
                composable("info") {
                    RestaurantInfoScreen(
                        viewModel = restaurantInfoViewModel,
                        reviewImageUrl = reviewImageUrl,
                        restaurantImageUrl = restaurantImageUrl
                    )
                }
                composable("menu") {
                    RestaurantMenu()
                }
                composable("review") {
                    RestaurantReview()
                }
                composable("gallery") {
                    RestaurantGallery()
                }
            }
        }
    }

}
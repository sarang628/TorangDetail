import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun RestaurantScreen() {
    val navController = rememberNavController()
    Column {
        RestaurntTopMenu(navController)
        NavHost(navController = navController, startDestination = "info") {
            composable("info") {
                //restaurant_information.RestaurantInformation()
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
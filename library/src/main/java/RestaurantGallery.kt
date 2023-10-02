import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.torang_detail.R

@Preview
@Composable
fun RestaurantGallery() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.colorSecondaryLight))
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(150.dp), content = {
            items(100) {
                AsyncImage(
                    modifier = Modifier.padding(1.dp),
                    model = "http://sarang628.iptime.org:89/review_images/1/1/2023-09-11/10_37_51_976.jpeg",
                    contentDescription = ""
                )
            }
        })
    }
}
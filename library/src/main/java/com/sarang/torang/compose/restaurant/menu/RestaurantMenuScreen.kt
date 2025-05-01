package com.sarang.torang.compose.restaurant.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sarang.torang.data.restaurant.MenuData
import com.sarang.torang.data.restaurant.testMenuData
import com.sarang.torang.viewmodels.RestaurantMenuViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantMenuScreen(
    viewModel: RestaurantMenuViewModel = hiltViewModel(),
    restaurantId: Int,
    progressTintColor: Color? = null,
    columnCount: Int = 1,
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> },
    pullToRefreshLayout: @Composable (isRefreshing: Boolean, onRefresh: (() -> Unit), contents: @Composable (() -> Unit)) -> Unit = { _, _, _ -> }
) {
    val coroutine = rememberCoroutineScope()
    LaunchedEffect(key1 = restaurantId, block = {
        viewModel.loadMenu(restaurantId)
    })
    val uiState = viewModel.uiState
    val state = rememberPullToRefreshState()
    pullToRefreshLayout.invoke(
        false,
        {
            coroutine.launch {
                viewModel.loadMenu(restaurantId)
                //state.updateState(RefreshIndicatorState.Default)
            }
        }) {
        RestaurantMenu(
            list = uiState,
            progressTintColor = progressTintColor,
            imageLoader = imageLoader,
            columnCount = columnCount
        )
    }
}

@Composable
fun RestaurantMenu(
    list: List<MenuData>,
    progressTintColor: Color? = null,
    columnCount: Int = 1,
    isSmallMenuItem: Boolean = false,
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> }
) {
    LazyVerticalGrid(columns = GridCells.Fixed(columnCount), content = {
        items(list.size) {
            var menu = list[it]
            if (!isSmallMenuItem) {
                MenuItem(
                    menu = menu,
                    progressTintColor = progressTintColor,
                    imageLoader = imageLoader
                )
            } else {
                SmallMenuItem(
                    menu = menu,
                    progressTintColor = progressTintColor,
                    imageLoader = imageLoader
                )
            }
        }
    })
}

@Composable
fun RestaurantMenuColumn(
    modifier: Modifier = Modifier,
    menus: List<MenuData> = listOf(),
    progressTintColor: Color? = null,
    columnCount: Int = 1,
    isSmallMenuItem: Boolean = false,
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> }
) {
    Column(modifier) {
        menus.chunked(columnCount).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                rowItems.forEach { menu ->
                    if (isSmallMenuItem) {
                        SmallMenuItem(
                            menu = menu,
                            progressTintColor = progressTintColor,
                            modifier = Modifier.weight(1f),
                            imageLoader = imageLoader
                        )
                    } else {
                        MenuItem(
                            menu = menu,
                            progressTintColor = progressTintColor,
                            imageLoader = imageLoader
                        )
                    }
                }
                // 빈 칸 채우기
                repeat(columnCount - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    menu: MenuData,
    progressTintColor: Color? = null,
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> }
) {
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp, top = 2.dp, bottom = 2.dp)
    ) {
        imageLoader.invoke(Modifier.fillMaxSize(), menu.url, null, null, ContentScale.Crop)

        Box(
            Modifier
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(5.dp))
                .padding(start = 8.dp, bottom = 8.dp)
                .background(Color(0x99000000))
        ) {
            Column(Modifier.padding(4.dp)) {
                AndroidViewRatingBar(rating = 3.0f, progressTintColor = progressTintColor)
                Text(
                    text = "${menu.menuName} (${menu.price})",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun SmallMenuItem(
    modifier: Modifier = Modifier,
    menu: MenuData,
    progressTintColor: Color? = null,
    imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> }
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp, top = 2.dp, bottom = 2.dp)
    ) {
        imageLoader.invoke(Modifier.fillMaxSize(), menu.url, 20.dp, 20.dp, ContentScale.Crop)
        Box(
            Modifier
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(5.dp))
                .padding(start = 4.dp, bottom = 4.dp)
                .background(Color(0x66000000))
        ) {
            Column(Modifier.padding(2.dp)) {
                Text(
                    text = "${menu.menuName}-${menu.price.toInt()}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenuItem() {
    MenuItem(menu = testMenuData())
}

@Preview
@Composable
fun PreviewSmallMenuItem() {
    SmallMenuItem(menu = MenuData.empty().copy(menuName = "menuName", price = 4000f))
}

@Preview
@Composable
fun PreviewRestaurantMenuColumn(modifier : Modifier = Modifier, imageLoader: @Composable (Modifier, String, Dp?, Dp?, ContentScale?) -> Unit = { _, _, _, _, _ -> }) {
    RestaurantMenuColumn(
        //@formatter:off
        modifier = modifier,
        menus = listOf(
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_728.jpg", menuName = "hanburgerhanburgerhanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_740.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_753.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_765.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_782.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_792.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_801.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_812.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_822.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_20_923.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_36_394.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_36_404.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_53_226.jpg", menuName = "hanburger", price = 12000f),
            testMenuData().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_53_237.jpg", menuName = "hanburger", price = 12000f),
        ),
        columnCount = 3,
        isSmallMenuItem = true,
        imageLoader = imageLoader
        //@formatter:on
    )
}
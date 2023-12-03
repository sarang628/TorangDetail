package com.sryang.torang.compose.restaurant

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun RestaurntTopMenu(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var state by remember { mutableStateOf(0) }
    val titles = listOf("info", "menu", "review", "gallery")
    Log.d("RestaurntTopMenu1", currentDestination?.route.toString())
    Column {
        PrimaryTabRow(
            selectedTabIndex = if (currentDestination == null) 0 else titles.indexOf(
                currentDestination.route.toString()
            )
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = currentDestination?.hierarchy?.any { it.route == titles[index] } == true,
                    onClick = {
                        state = index
                        navController.navigate(titles[index]) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    },
                    text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                )
            }
        }
    }
}
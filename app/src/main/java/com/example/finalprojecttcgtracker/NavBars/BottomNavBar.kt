package com.example.finalprojecttcgtracker.NavBars

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Composable function for displaying the bottom navigation bar.
 *
 * @param navController the NavHostController used to handle navigation
 * between screens.
 *
 * Displays navigation items for Home, Collection, and Wishlist screens.
 */
@Composable
fun BottomNavBar(navController: NavHostController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val items = listOf(
        "home" to "Home",
        "collection" to "Collection",
        "wishlist" to "Wishlist"
    )

    NavigationBar {
        items.forEach { (route, label) ->
            NavigationBarItem(
                label = { Text(text = label) },
                selected = currentRoute == route,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                },
                icon = { /* Icon */ },
                enabled = true,
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.Blue,
                    unselectedTextColor = Color.Gray
                ),
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    }
}
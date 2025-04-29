package com.example.finalprojecttcgtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalprojecttcgtracker.Screens.HomeScreen
import com.example.finalprojecttcgtracker.Screens.CollectionScreen
import com.example.finalprojecttcgtracker.Screens.WishlistScreen
import com.example.finalprojecttcgtracker.NavBars.BottomNavBar

/**
 * MainActivity is the entry point of the app.
 *
 * Sets up user interface like the bottom navigation bar
 * as well as the navigation between screens.
 *
 * Utilizes Jetpack Compose to set the UI and manage navigation within the app.
 * This is handled by using NavHostController and NavHost with my custom
 * BottomNavBar to allow transitions between screens.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Create NavController for navigation
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    BottomNavBar(navController) // Add Bottom Navigation Bar
                }
            ) { paddingValues ->
                // Wrap the NavHost inside the Scaffold to handle padding
                Box(modifier = Modifier.padding(paddingValues)) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("collection") {
                            CollectionScreen()
                        }
                        composable("wishlist") {
                            WishlistScreen()
                        }
                    }
                }
            }
        }
    }
}
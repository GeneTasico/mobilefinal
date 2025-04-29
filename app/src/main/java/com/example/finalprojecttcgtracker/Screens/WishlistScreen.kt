package com.example.finalprojecttcgtracker.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalprojecttcgtracker.NavBars.CustomTopAppBar

/**
 * Composable screen displaying the user's wish Pokemon to catch
 * Includes a total count and space for a scrollable list similar
 * to the home screen.
 */
@Composable
fun WishlistScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        CustomTopAppBar("My Wishlist")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Total Pokemon: x")
        // Scrolling List
    }
}
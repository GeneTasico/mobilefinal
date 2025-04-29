package com.example.finalprojecttcgtracker.NavBars

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Custom top app bar displaying a title.
 */
@Composable
fun CustomTopAppBar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.weight(1f))
    }
}
package com.example.finalprojecttcgtracker

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalprojecttcgtracker.Models.Pokemon

/**
 * Displays the dialog showing the details about a Pokemon.
 *
 * Includes:
 * - Typing
 * - Ability(s)
 *
 * @param pokemon The Pokemon whose details are to be displayed.
 * @param onDismiss A callback function to be invoked when the dialog is closed.
 */
@Composable
fun CardDetailsDialog(pokemon: Pokemon, onDismiss: () -> Unit) {
    /**
     * AlertDialog to display the details.
     */
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Pokemon Details") },
        text = {
            Column(modifier = Modifier.padding(16.dp)) {
                // Display Pokémon Name
                Text("Name: ${pokemon.name}", style = MaterialTheme.typography.bodyLarge)

                Spacer(modifier = Modifier.height(8.dp))

                // Display Pokémon Abilities
                Text(
                    "Abilities: ${pokemon.abilities.joinToString(", ") { it.name }}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Display Pokémon Types
                Text(
                    "Types: ${pokemon.types.joinToString(", ") { it.type.name }}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Close Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = onDismiss) {
                        Text("Close")
                    }
                }
            }
        },
        confirmButton = {}
    )
}
package com.example.finalprojecttcgtracker.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finalprojecttcgtracker.API.RetrofitObject
import com.example.finalprojecttcgtracker.Models.Pokemon
import com.example.finalprojecttcgtracker.CardDetailsDialog
import kotlinx.coroutines.launch

/**
 * Composable function for the home screen.
 * Includes:
 * - Search bar
 * - Clear button for the search bar
 * - LazyColumn to show Pokemon in the PokeDex
 * - Tapping a Pokemon displays detail dialog.
 *
 * @param navController Controller used for navigation between screens.
 */
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        var pokemonList by remember { mutableStateOf<List<Pokemon>>(emptyList()) }
        var searchQuery by remember { mutableStateOf("") }
        var showDialog by remember { mutableStateOf(false) }
        var selectedPokemon by remember { mutableStateOf<Pokemon?>(null) }
        val scope = rememberCoroutineScope()

        /**
         * LaunchedEffect that fetches the initial list of Pokemon
         * and then fetches their associated details.
         *
         * Data is loaded asynchronously.
         */
        LaunchedEffect(Unit) {
            try {
                // Fetch the list of available Pokémon names
                val response = RetrofitObject.pokeApiService.getPokemonList()
                val loadedPokemon = mutableListOf<Pokemon>()

                // For each result in the list, fetch its details
                for (result in response.results) {
                    val detailResponse = RetrofitObject.pokeApiService.getPokemon(result.name)
                    if (detailResponse.isSuccessful) {
                        detailResponse.body()?.let { detail ->
                            val pokemon = Pokemon(
                                name = detail.name,
                                abilities = detail.abilities.map { it.ability },
                                types = detail.types
                            )
                            loadedPokemon.add(pokemon)
                        }
                    }
                }
                pokemonList = loadedPokemon
            } catch (e: Exception) {
                Log.e("HomeScreen", "Error loading initial Pokémon: ${e.message}")
            }
        }

        /**
         * Row containing the search and clear buttons.
         */
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                placeholder = { Text("Search for Pokémon...") },
                singleLine = true
            )

            /**
             * Clears the search bar.
             */
            if (searchQuery.isNotEmpty()) {
                Button(
                    onClick = {
                        searchQuery = ""
                        pokemonList = emptyList()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Clear", color = Color.White)
                }

                Spacer(modifier = Modifier.width(8.dp))
            }

            /**
             * Button to trigger the search bar.
             *
             * Returns pokemon of the same name from the API.
             */
            Button(
                onClick = {
                    scope.launch {
                        if (searchQuery.isNotEmpty()) {
                            try {
                                val response = RetrofitObject.pokeApiService.getPokemon(searchQuery.lowercase())
                                if (response.isSuccessful) {
                                    response.body()?.let { pokemonDetailResponse ->
                                        val pokemon = Pokemon(
                                            name = pokemonDetailResponse.name,
                                            abilities = pokemonDetailResponse.abilities.map { it.ability },
                                            types = pokemonDetailResponse.types
                                        )
                                        pokemonList = listOf(pokemon)
                                        Log.d("HomeScreen", "Pokemon fetched: ${pokemon.name}")
                                    }
                                } else {
                                    Log.e("HomeScreen", "Failed to fetch Pokemon details")
                                    pokemonList = emptyList()
                                }
                            } catch (e: Exception) {
                                Log.e("HomeScreen", "Error fetching data: ${e.message}")
                                pokemonList = emptyList()
                            }
                        } else {
                            pokemonList = emptyList()
                        }
                    }
                }
            ) {
                Text("Search")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Number of Pokémon found: ${pokemonList.size}")

        Spacer(modifier = Modifier.height(16.dp))

        /**
         * LazyColumn to display all the Pokemon
         *
         * Each item is clickable to view Pokemon details.
         */
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(pokemonList) { pokemon ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.LightGray)
                        .padding(8.dp)
                        .clickable {
                            selectedPokemon = pokemon
                            showDialog = true
                        }
                ) {
                    Text("Tap to see details: ${pokemon.name}", modifier = Modifier.align(Alignment.Center))
                }
            }
        }

        /**
         * Shows a dialog that displays Pokemon information
         * like their abilities and typings.
         */
        if (showDialog && selectedPokemon != null) {
            CardDetailsDialog(
                pokemon = selectedPokemon!!,
                onDismiss = { showDialog = false }
            )
        }
    }
}
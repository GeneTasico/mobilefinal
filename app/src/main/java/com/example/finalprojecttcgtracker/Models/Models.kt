package com.example.finalprojecttcgtracker.Models

/**
 * Pokemon with its name, ability and types.
 */
data class Pokemon(
    val name: String,
    val abilities: List<AbilityDetails>,
    val types: List<TypeEntry>
)

/**
 * Abilities of the Pokemon
 */
data class Ability(
    val ability: AbilityDetails
)

/**
 * Detailed information of the ability.
 */
data class AbilityDetails(
    val name: String
)

/**
 * Types of the Pokemon
 */
data class TypeEntry(
    val slot: Int,
    val type: TypeDetails
)

/**
 * Detailed information of the type.
 */
data class TypeDetails(
    val name: String,
    val url: String
)

// Response Classes

/**
 * Response object for a list of Pokemon results.
 */
data class PokemonListResponse(
    val results: List<PokemonListResult>
)

/**
 * Individual Pokemon entry in a list response.
 */
data class PokemonListItem(
    val name: String,
    val url: String
)

/**
 * Response object for a single Pokemon including its
 * ability and types.
 */
data class PokemonDetailResponse(
    val name: String,
    val abilities: List<AbilityEntry>,
    val types: List<TypeEntry>
)

/**
 * Ability entry inside a Pokemon's details.
 */
data class AbilityEntry(
    val ability: AbilityDetails
)

/**
 * Response object for a list of all Pokemon abilities.
 */
data class AbilityListResponse(
    val results: List<Ability>
)

/**
 * Response for a specific Pokemon ability.
 */
data class AbilityDetailResponse(
    val id: Int,
    val name: String,
    val effect_entries: List<EffectEntry>
)

/**
 * Effects of an ability.
 */
data class EffectEntry(
    val effect: String,
    val short_effect: String
)

/**
 * Response object for a list of all Pokemon types.
 */
data class TypeListResponse(
    val results: List<TypeListItem>
)

/**
 * Individual type entry in a type list response.
 */
data class TypeListItem(
    val name: String,
    val url: String
)

/**
 * Response for a specific Pokemon type.
 */
data class TypeDetailResponse(
    val id: Int,
    val name: String,
    val pokemon: List<PokemonTypeEntry> // List of Pokémon that belong to this type
)

/**
 * Pokemon entry associated with a specific type.
 */
data class PokemonTypeEntry(
    val pokemon: PokemonListItem
)

/**
 * Pokemon result in a general list response.
 */
data class PokemonListResult(
    val name: String,
    val url: String
)
package com.example.finalprojecttcgtracker.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.finalprojecttcgtracker.Models.*

/**
 * Interface defining API endpoints for interacting with the Pokémon API.
 */
interface PokeApiService {

    /**
     * Fetches a list of Pokémon with optional pagination.
     *
     * @param limit The number of Pokémon to return.
     * @param offset The offset from the start of the list.
     * @return A [Response] containing a [PokemonListResponse].
     */
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<PokemonListResponse>

    /**
     * Fetches details for a specific Pokémon by name.
     *
     * @param name The name of the Pokémon.
     * @return A [Response] containing a [PokemonDetailResponse].
     */
    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Response<PokemonDetailResponse>

    /**
     * Fetches a list of all Pokémon abilities.
     *
     * @return A [Response] containing an [AbilityListResponse].
     */
    @GET("ability?limit=400")
    suspend fun getAllAbilities(): Response<AbilityListResponse>

    /**
     * Fetches details about a specific Pokémon ability by name.
     *
     * @param name The name of the ability.
     * @return A [Response] containing an [AbilityDetailResponse].
     */
    @GET("ability/{name}")
    suspend fun getAbility(
        @Path("name") name: String
    ): Response<AbilityDetailResponse>

    /**
     * Fetches a list of all Pokémon types.
     *
     * @return A [Response] containing a [TypeListResponse].
     */
    @GET("type")
    suspend fun getAllTypes(): Response<TypeListResponse>

    /**
     * Fetches details about a specific Pokémon type by name.
     *
     * @param name The name of the type.
     * @return A [Response] containing a [TypeDetailResponse].
     */
    @GET("type/{name}")
    suspend fun getType(
        @Path("name") name: String
    ): Response<TypeDetailResponse>

    /**
     * Fetches a default list of Pokémon limited to 20 for the home screen.
     *
     * @return A [PokemonListResponse] containing a list of Pokémon.
     */
    @GET("pokemon?limit=20")
    suspend fun getPokemonList(): PokemonListResponse
}
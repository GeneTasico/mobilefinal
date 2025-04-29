package com.example.finalprojecttcgtracker.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton object that provides a configured instance of Retrofit
 * for accessing the Pokemon API.
 */
object RetrofitObject {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    /**
     * Initialized Retrofit instance with Gson converter and OkHttp client.
     */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .build() // No interceptors needed
            )
            .build()
    }

    /**
     * Initialized Service for interacting with the Pokemon API endpoints.
     */
    val pokeApiService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}
package com.nels.master.androidpractices

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon/")
    suspend fun getPokemons(@Query("limit") limit: Int = 25, @Query("offset") offset: Int): PokemonDto


    companion object{
        const val URL_BASE = "https://pokeapi.co/api/v2/"
    }

}


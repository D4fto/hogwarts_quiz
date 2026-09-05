package com.example.template.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Personagem(
    val fullName: String,
    val image: String,
    val hogwartsHouse: String
)

interface ApiInterface {
    @GET("pt/characters/random")
    suspend fun getRandomPersonagem(): Personagem
}

object ApiService {
    private const val baseUrl = "https://potterapi-fedeperin.vercel.app/"

    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}
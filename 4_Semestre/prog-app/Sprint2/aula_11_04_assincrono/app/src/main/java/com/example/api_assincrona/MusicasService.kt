package com.example.api_assincrona

import retrofit2.Response
import retrofit2.http.GET

interface MusicasService {
    @GET("/musicas")
    suspend fun getAll(): Response<List<Musica>>
}
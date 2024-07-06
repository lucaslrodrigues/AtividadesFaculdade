package com.example.api_assincrona

import retrofit2.Response

interface IMusicaRepository {
    suspend fun getAll(): Response<List<Musica>>
}
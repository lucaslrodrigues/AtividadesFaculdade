package com.example.api_assincrona

import retrofit2.Response

class MusicaRepositoryImpl : IMusicaRepository {
    override suspend fun getAll(): Response<List<Musica>> {
        val api = ApiConfig
            .getInstance()
            .create(MusicasService::class.java)
        return api.getAll()
    }
}
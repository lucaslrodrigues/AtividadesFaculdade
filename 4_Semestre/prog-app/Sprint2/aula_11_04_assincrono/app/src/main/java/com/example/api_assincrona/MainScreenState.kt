package com.example.api_assincrona

sealed interface MainScreenState {
    data object Loading: MainScreenState
    data class Success(
        val data: List<Musica>
    ): MainScreenState
    data class Error(
        val message: String
    ): MainScreenState
}
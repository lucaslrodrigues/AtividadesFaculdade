package com.example.api_assincrona

import android.net.http.HttpEngine
import android.net.http.HttpException
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel(
    private val repository: IMusicaRepository
) : ViewModel() {
    var state = MutableLiveData<MainScreenState>(MainScreenState.Loading)
        private set

    fun getAllMusicas() {
            viewModelScope.launch { // Launch inicia uma nova tread paralela
                // É necessário trocar de tread para que a tread principal não congele a tela
                try {
                    state.value = MainScreenState.Loading
                    val musicaRepository = ApiConfig
                        .getInstance()
                        .create(MusicasService::class.java)
                    val response = repository.getAll()
                    if (response.isSuccessful) {
                        val list = response.body() ?: emptyList()
                        state.value = MainScreenState.Success(data = list)
                    } else {
                        // TODO:
                        throw Exception("Erro desconhecido")
                    }

                }catch (e: retrofit2.HttpException) {
                    val message = when (e.code()) {
                        400 -> "Música não encontrada"
                        404 -> "Parâmetros incorretos"
                        else -> "Erro desconhecido"
                    }
                    state.value = MainScreenState.Error(message)
                } catch (e: Exception) {
                    state.value = MainScreenState.Error(
                        e.message ?: "Erro desconhecido"
                    )
                }
            }
        }
        // O viewModelScope atrela o código ao escopo da viewModel atual, ele morre ao fim da view model

}
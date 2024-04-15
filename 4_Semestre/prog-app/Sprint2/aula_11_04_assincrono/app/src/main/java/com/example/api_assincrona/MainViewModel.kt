package com.example.api_assincrona

import android.net.http.HttpEngine
import android.net.http.HttpException
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {
    var isLoading = MutableLiveData(false)
        private set

    var isSuccess = MutableLiveData<List<Musica>>(emptyList())
        private set

    var isError = MutableLiveData(false)

    var errorMessage = MutableLiveData("")
    fun getAllMusicas() {
        try{
            viewModelScope.launch { // Launch inicia uma nova tread paralela
                // É necessário trocar de tread para que a tread principal não congele a tela
                isLoading.value = true
                val musicaRepository = ApiConfig
                    .getInstance()
                    .create(MusicasService::class.java)
                val response = musicaRepository.getAll()
                if (response.isSuccessful) {
                    val list = response.body() ?: emptyList()
                    isSuccess.value = list
                    isLoading.value = false
                } else {
                    // TODO:
                    throw Exception("Erro desconhecido")
                }
            }
        } catch (e: retrofit2.HttpException){
            val message = when (e.code()) {
               400 -> "Música não encontrada"
               404 -> "Parâmetros incorretos"
               else -> "Erro desconhecido"
            }
            isError.value = true
            errorMessage.value = message
            isLoading.value = false
        } catch (e: Exception) {
            isError.value = true
            errorMessage.value = e.message
            isLoading.value = false
        }
        // O viewModelScope atrela o código ao escopo da viewModel atual, ele morre ao fim da view model
    }
}

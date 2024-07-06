package com.example.api_assincrona

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<IMusicaRepository> {
        LocalMusicaRepositoryImpl()
    }
    viewModel {
        MainViewModel(get())
    }
}
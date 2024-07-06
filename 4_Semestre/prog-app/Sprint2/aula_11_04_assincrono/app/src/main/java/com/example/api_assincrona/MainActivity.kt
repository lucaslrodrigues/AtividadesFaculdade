package com.example.api_assincrona

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.api_assincrona.ui.theme.Api_assincronaTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Api_assincronaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val vm = viewModel<MainViewModel>()
                    vm.getAllMusicas()
                    App(vm)
                }
            }
        }
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
    }
}

@Composable
fun App(vm: MainViewModel) {
    val state by vm.state.observeAsState()
    when (state) {
        is MainScreenState.Loading -> {
            LoadingBar()
        }
        is MainScreenState.Error, null -> {
            val errorMessage =
                (state as MainScreenState.Error).message
            ErrorView(message = errorMessage) {
                vm.getAllMusicas()
            }
        }
        is MainScreenState.Success -> {
            val musicas =
                (state as MainScreenState.Success).data
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(musicas) { musica ->
                    MusicaCard(
                        data = musica
                    )
                }
            }
        }
    }

}
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
    }
}

@Composable
fun App(vm: MainViewModel) {

    val isLoading by vm.isLoading.observeAsState()
    val isSuccess by vm.isSuccess.observeAsState()
    val isError by vm.isError.observeAsState()

    if (isLoading == true){
        LoadingBar()
    } else if (isError == true) {
        ErrorView() {
            vm.getAllMusicas()
        }
    } else {
        LazyColumn() {
            items(isSuccess!!) {musica ->
                Text(text = musica)
            }
        }
    }

}
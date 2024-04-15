package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val viewModel = viewModel<MainViewModel>()

    val counter by remember {
        viewModel.counter
    }

    val background by remember {
        viewModel.background
    }

    Surface (
        modifier = modifier.fillMaxSize(),
        color = background
    ){
        Column {
            Button(onClick = {viewModel.incrementCounter()}) {
                Text(text = "Clique para aumentar")
            }
            Text(text = "Clicou $counter vezes!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() { MyApplicationTheme {
        App()
    }
}
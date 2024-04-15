package com.example.aula_28_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aula_28_03.ui.theme.Aula_28_03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula_28_03Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val viewModel = viewModel<MainViewModel>()
    val emails = viewModel.getEmails()
    LazyColumn {
        items(emails) {
            email ->
            EmailCard(data = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Aula_28_03Theme {
        App()
    }
}
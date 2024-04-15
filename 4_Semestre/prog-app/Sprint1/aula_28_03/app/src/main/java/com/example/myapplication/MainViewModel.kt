package com.example.myapplication

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var counter = mutableStateOf(0)
        private set

    var background = mutableStateOf(Color.White)
        private set

    fun incrementCounter() {
        background.value = when (++counter.value) {
            in 0 .. 5 -> Color.Green
            in 6 .. 10 -> Color.Yellow
            else -> Color.Red
        }
    }
}
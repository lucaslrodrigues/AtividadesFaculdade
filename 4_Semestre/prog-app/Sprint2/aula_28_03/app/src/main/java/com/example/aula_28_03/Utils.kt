package com.example.aula_28_03

import androidx.compose.ui.graphics.Color

object Utils {

    fun getRandomColor(): String {
        val lettersList = listOf("A", "B", "C", "D", "E", "F")
        return "${lettersList.random()}${(0..9).random()}"
    }

    fun getRandomLetter(): String {
        val lettersList = listOf(
            "A", "B", "C", "D",
            "E", "F", "G", "H",
            "I", "J", "K", "L",
            "M", "N", "O", "P",
            "Q", "R", "S", "T",
            "U", "V", "W", "X",
            "Y", "Z"
        )
        return lettersList.random()
    }

    fun colorFromHexadecimal(hexadecimal: String): Color {
        return Color(
            android.graphics.Color.parseColor(hexadecimal)
        )
    }

}
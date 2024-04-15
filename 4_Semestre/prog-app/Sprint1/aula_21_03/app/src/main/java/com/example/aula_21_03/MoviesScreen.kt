package com.example.nav.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoviesScreen() {
    Surface(
        color = Color.Black,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "@Composable fun MoviesScreen",
                color = Color.White,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }
    }
}
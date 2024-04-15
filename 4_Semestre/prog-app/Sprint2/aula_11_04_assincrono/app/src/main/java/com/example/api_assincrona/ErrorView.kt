package com.example.api_assincrona

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.api_assincrona.ui.theme.Api_assincronaTheme

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    message: String = "Um erro inesperado ocorreu",
    retryAction: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Gray,
            text = message
        )
        Button(onClick = { retryAction() }) {
            Text(text = "Tentar novamente")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorViewPreview() {
    Api_assincronaTheme {
        ErrorView {}
    }
}
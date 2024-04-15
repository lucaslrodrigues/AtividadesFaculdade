package com.example.projeto_teste_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto_teste_01.ui.theme.Projeto_teste_01Theme
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto_teste_01Theme {
               app()
            }
        }
    }
}

@Composable
fun app () {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = "Calculadora IMC",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 26.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.width(16.dp))
        var nome by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nome,
            onValueChange = { valor: String ->
                nome = valor
            },
            label = {
                Text("Nome")
            },
            placeholder = {
                Text("Digite o seu nome completo")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))


        var altura by remember {
            mutableStateOf("")
        }
        var peso by remember {
            mutableStateOf("")
        }
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            OutlinedTextField(
                modifier = Modifier.weight(.5f),
                value = altura,
                onValueChange = { valor: String ->
                    altura = valor
                },
                label = {
                    Text("Altura (cm)")
                },
                placeholder = {
                    Text("Digite sua altura em cm")
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                modifier = Modifier.weight(.5f),
                value = peso,
                onValueChange = { valor: String ->
                    peso = valor
                },
                label = {
                    Text("Peso (Kg)")
                },
                placeholder = {
                    Text("Digite seu peso em Kg")
                }
            )
        }

        var mensagem by remember {
            mutableStateOf("Nada para ver aqui")
        }
        var corBox by remember {
            mutableStateOf(Color.Red)
        }



        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier.align(alignment = Alignment.End),
            onClick = {
                var imc = calcularImc(altura, peso)
                if (imc.isNotEmpty()) {
                    mensagem = "$nome seu imc é $imc"
                    corBox = Color.Green
                }
                else mensagem = "Digite o peso e a altura!"
            }
        ) {
            Text(text = "Calcular")
        }

        var isBoxOpen by remember {
            mutableStateOf(false)
        }

        Text(
            text = if (isBoxOpen) "Fechar resultado"
            else "ver resultado",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    isBoxOpen = !isBoxOpen
                }
                .padding(16.dp)
        )

        if (isBoxOpen) {
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        corBox,
                        RoundedCornerShape(10.dp)
                    )
            ) {
                Text(
                    text = mensagem,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}

fun calcularImc (altura: String, peso: String): String {
    if (altura.isNotEmpty() || peso.isNotEmpty()) {
        val alturaQuadrado = (altura.toDouble() / 100).pow(2)
        val imc = peso.toDouble() / alturaQuadrado
        return "%.2f".format(imc)
    } else {
        return ""
    }
}

@Preview(showBackground = true)
@Composable
fun appPreview(){
    Projeto_teste_01Theme {
        app()
    }
}
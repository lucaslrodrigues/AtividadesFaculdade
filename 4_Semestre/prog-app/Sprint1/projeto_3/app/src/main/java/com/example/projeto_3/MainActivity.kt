package com.example.projeto_3

import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.projeto_3.ui.theme.Projeto3Theme

// Para modificar um elemento utilizar:
// Modifier que tem modificações gerais
// Os modificadores do próprio elemento

// Arragemente = horizontal
// Aligment = Vertical
// A column inverte os anteriores

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projeto3Theme {

            }
        }
    }
}

// data class = Funciona como um DTO manipulando dados de uma entidade
data class Story(
    val id: Int,
    val text: String,
    val imagem: Int = R.drawable.img_primeira
)

val storys = listOf(
    Story(
        id = 1,
        imagem = R.drawable.img_primeira,
        text = "Novidades"),
    Story(
        id = 2,
        imagem = R.drawable.img_primeira,
        text = "Séries"),
    Story(
        id = 3,
        imagem = R.drawable.img_primeira,
        text = "Docs"),
    Story(
        id = 4,
        imagem = R.drawable.img_primeira,
        text = "Ação"),
    Story(
        id = 5,
        imagem = R.drawable.img_primeira,
        text = "Aventura"),
)

@Composable
fun StoryItemList(){
    LazyRow(
        // horizontalArrangement = como os itens estão na horizontal
        horizontalArrangement =
        Arrangement.spacedBy(8.dp),
//        verticalAlignment = ,

        contentPadding = PaddingValues(
            horizontal = 16.dp
        )
//        modifier = Modifier
//            .padding(horizontal = 16.dp)

    ) {
        items(storys) { story -> // Renomeando o "it"
            StoryItem(
                imagem = story.imagem,
                text = story.text)
        }
    }

//    Row {
//        List(4){
//            StoryItem(R.drawable.img_primeira,
//                "Story ${it+1}")
//        }
////        StoryItem(R.drawable.img_primeira,
////            stringResource(id = R.string.story))
////        StoryItem(R.drawable.img_primeira, "Story 2")
////        StoryItem(R.drawable.img_primeira, "Story 3")
////        StoryItem(R.drawable.img_primeira, "Story 4")
//    }
}

@Preview(
    showBackground = true,
    widthDp = 300 // Já passa com o dp
)
@Composable
fun StoryItemListPreview(){
    StoryItemList()
}

@Composable
fun StoryItem(
    @DrawableRes imagem: Int, // Isso define que o recurso precisa ser do tipo drawable
    text: String,
//    @StringRes text: String
) {
    R.drawable.img_primeira
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Image é um drawble = Aquilo que pode ser desenhado (um vetor). Temos toda vez que pegarmos uma imagem externa
        // Resource manager = recursos externos e definição de padrões para o projeto (internacionalização, i18n)
        // Shift + shift = Pesquisar coisas (String.xml é uma boa pratica)

        // Painter resource = Carrega um recurso global
        // R = Classe global que serve como lista de referencia de todos os recursos
        // drawable = Tem a lista dde todos os id de todos os recursos
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
//            painter = painterResource(id = R.drawable.img_primeira),
            painter = painterResource(id = imagem),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = text,
            style = MaterialTheme.typography.titleSmall
//            fontWeight = FontWeight.Bold,
            )
    }
}

@Preview(showBackground = true)
@Composable
fun StoryItemPreview(){
    StoryItem(
        R.drawable.img_primeira, "Story 1"
    )
}

@Composable
fun ImageItem(
    @DrawableRes imagem: Int
) {
    Column {
        Text(text = "Medievais")
        Image(
            modifier = Modifier
                .size(80.dp),
//                .clip(),
            painter = painterResource(id = imagem),
            contentDescription = null
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview(){
    ImageItem(
        R.drawable.img_primeira
    )
}

@Composable
fun ImageWindow(
    imagem: Int
){
    ImageItem(imagem = imagem)
}


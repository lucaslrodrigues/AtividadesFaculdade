package com.example.api_assincrona

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.CachePolicy

@Composable
fun MusicaCard(
    data: Musica,
    modifier: Modifier = Modifier
) {
    initializeCoil(LocalContext.current)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
    ) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(8.dp),
            model = data.albumCapa,
            contentDescription = null,
        )
        Column {
            Text(
                text = data.nome,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = data.artista,
            )
        }
    }
}

fun initializeCoil(context: Context) {
    Coil.setImageLoader {
        ImageLoader.Builder(context)
            .crossfade(true)
            .allowHardware(false)
            .diskCachePolicy(CachePolicy.DISABLED)
            .memoryCachePolicy(CachePolicy.DISABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .build()
    }
}
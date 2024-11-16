package com.laamile.animalzukan.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.laamile.animalzukan.common.model.DetailAnimalModel

@Composable
fun AnimalDetailContent(
    animal: DetailAnimalModel,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onPlaySound: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        // 動物の画像
        Image(
            painter = rememberAsyncImagePainter(animal.imageURL),
            contentDescription = "Image of ${animal.commonName}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 24.dp) // 余白を広げる
        )

        // 動物の名前と学名
        Text(
            text = animal.commonName,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Scientific Name: ${animal.scientificName}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // お気に入りボタン
        IconButton(onClick = onToggleFavorite) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 鳴き声再生ボタン
        Button(
            onClick = onPlaySound, modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play Sound",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = "Play Sound")
        }

        // 詳細情報をセクションごとに表示
        AnimalDetailSection(title = "Description", content = animal.description)
        AnimalDetailSection(title = "Habitat", content = animal.habitat)
        AnimalDetailSection(title = "Diet", content = animal.diet)
        AnimalDetailSection(title = "Lifespan", content = animal.lifespan)
        AnimalDetailSection(
            title = "Conservation Status", content = animal.conservationStatus
        )
    }
}

@Composable
private fun AnimalDetailSection(title: String, content: String?) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
    )
    Text(
        text = content ?: "", style = MaterialTheme.typography.bodyMedium
    )
}
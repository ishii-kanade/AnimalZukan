package com.laamile.animalzukan.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.laamile.animalzukan.common.util.toAnimalEntity

@Composable
fun AnimalDetailScreen(animalId: String?) {
    val viewModel: AnimalDetailViewModel = hiltViewModel()

    // 動物の詳細データを取得
    viewModel.fetchAnimalDetail(animalId ?: "1")
    val animalDetail by viewModel.animalDetail.collectAsState()
    val isFavorite by viewModel.isFavorite.collectAsState()

    // 詳細情報を表示するスクロール可能なレイアウト
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        animalDetail?.let { animal ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                // 動物の画像
                Image(
                    painter = rememberAsyncImagePainter(animal.animalByID?.imageURL),
                    contentDescription = "Image of ${animal.animalByID?.commonName}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(bottom = 24.dp) // 余白を広げる
                )

                // 動物の名前と学名
                Text(
                    text = animal.animalByID?.commonName ?: "",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Scientific Name: ${animal.animalByID?.scientificName}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(24.dp))

                // お気に入りボタン
                IconButton(onClick = { viewModel.toggleFavorite(animal.toAnimalEntity()) }) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites"
                    )
                }

                // 詳細情報をセクションごとに表示
                AnimalDetailSection(title = "Description", content = animal.animalByID?.description)
                AnimalDetailSection(title = "Habitat", content = animal.animalByID?.habitat)
                AnimalDetailSection(title = "Diet", content = animal.animalByID?.diet)
                AnimalDetailSection(title = "Lifespan", content = animal.animalByID?.lifespan)
                AnimalDetailSection(
                    title = "Conservation Status", content = animal.animalByID?.conservationStatus
                )
            }
        } ?: run {
            // データがロード中の場合にローディングインジケーターを表示
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun AnimalDetailSection(title: String, content: String?) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
    )
    Text(
        text = content ?: "", style = MaterialTheme.typography.bodyMedium
    )
}



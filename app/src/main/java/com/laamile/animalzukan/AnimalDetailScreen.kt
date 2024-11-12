package com.laamile.animalzukan

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
import androidx.compose.material3.CircularProgressIndicator
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

@Composable
fun AnimalDetailScreen(animalId: String?) {
    val viewModel: AnimalDetailViewModel = hiltViewModel()

    // 動物の詳細データを取得
    viewModel.fetchAnimalDetail(animalId ?: "1")
    val animalDetail by viewModel.animalDetail.collectAsState()

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
                        .height(200.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // 動物の名前と学名
                Text(
                    text = animal.animalByID?.commonName ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Scientific Name: ${animal.animalByID?.scientificName}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(16.dp))

                // その他の詳細情報
                Text(
                    text = "Description:",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = animal.animalByID?.description ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Habitat:",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = animal.animalByID?.habitat ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Diet:",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = animal.animalByID?.diet ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Lifespan:",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = animal.animalByID?.lifespan ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Conservation Status:",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = animal.animalByID?.conservationStatus ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        } ?: run {
            // データがロード中の場合にローディングインジケーターを表示
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}


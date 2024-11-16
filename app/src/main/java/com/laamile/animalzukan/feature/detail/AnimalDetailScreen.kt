package com.laamile.animalzukan.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
            AnimalDetailContent(
                animal = animal,
                isFavorite = isFavorite,
                onToggleFavorite = { viewModel.toggleFavorite(animal.toAnimalEntity()) },
                onPlaySound = { viewModel.playAnimalSound(animal.soundURL) }
            )
        } ?: run {
            // データがロード中の場合にローディングインジケーターを表示
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}



package com.laamile.animalzukan

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AnimalDetailScreen(animalId: String?) {
    // 詳細情報の取得と表示
    Text(text = "Animal Detail for ID: $animalId")
}

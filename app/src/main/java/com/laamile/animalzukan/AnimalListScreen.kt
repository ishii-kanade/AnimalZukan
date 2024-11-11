package com.laamile.animalzukan

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AnimalListScreen(
    modifier: Modifier = Modifier,
    viewModel: AnimalListViewModel = hiltViewModel() // ViewModelのインスタンスを取得
) {
    val animals by remember { derivedStateOf { viewModel.animals } }

    LazyColumn(modifier = modifier) {
        items(animals) { animal ->
            AnimalItem(animal = animal)
        }
    }
}


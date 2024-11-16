package com.laamile.animalzukan.feature.home

import AnimalItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AnimalListScreen(
    modifier: Modifier = Modifier,
    viewModel: AnimalListViewModel = hiltViewModel(),
    onAnimalClick: (String) -> Unit
) {
    val animals by viewModel.animals.collectAsState()

    LazyColumn(modifier = modifier) {
        items(animals) { animal ->
            AnimalItem(animalModel = animal, onClick = { onAnimalClick(it) })
        }
    }
}



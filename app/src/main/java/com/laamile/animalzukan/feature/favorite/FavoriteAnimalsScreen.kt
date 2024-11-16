package com.laamile.animalzukan.feature.favorite

import AnimalItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FavoriteAnimalsScreen(
    viewModel: FavoriteAnimalsViewModel = hiltViewModel(),
    onAnimalClick: (String) -> Unit
) {
    val favoriteAnimals by viewModel.favoriteAnimals.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoriteAnimals) { animal ->
            AnimalItem(animalModel = animal, onClick = { onAnimalClick(it) })
        }
    }
}


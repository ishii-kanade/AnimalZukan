package com.laamile.animalzukan

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun AnimalListScreen(
    modifier: Modifier = Modifier,
    animalRepository: AnimalRepository
) {
    val animals = remember { mutableStateListOf<GetAnimalsQuery.Animal>() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val response = animalRepository.getAnimals(10) // 取得するアニマル数を指定
            response?.data?.animals?.let { animals.addAll(it) }
        }
    }

    LazyColumn(modifier = modifier) {
        items(animals.toList()) { animal ->
            AnimalItem(animal = animal)
        }
    }
}

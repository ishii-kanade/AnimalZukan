package com.laamile.animalzukan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimalItem(animal: GetAnimalsQuery.Animal) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${animal.commonName}")
            Text(text = "Scientific Name: ${animal.scientificName}")
            Text(text = "Description: ${animal.description}")
            Text(text = "Habitat: ${animal.habitat}")
            Text(text = "Diet: ${animal.diet}")
        }
    }
}

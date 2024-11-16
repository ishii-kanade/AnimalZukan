package com.laamile.animalzukan.common.util

import com.laamile.animalzukan.GetAnimalsQuery
import com.laamile.animalzukan.common.model.AnimalModel

fun List<GetAnimalsQuery.Animal>.toAnimals(): List<AnimalModel> {
    return this.map { animal ->
        AnimalModel(
            animalID = animal.animalID,
            commonName = animal.commonName,
            scientificName = animal.scientificName,
            imageURL = animal.imageURL
        )
    }
}
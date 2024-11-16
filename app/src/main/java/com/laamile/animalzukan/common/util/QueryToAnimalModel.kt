package com.laamile.animalzukan.common.util

import com.laamile.animalzukan.GetAnimalByIDQuery
import com.laamile.animalzukan.GetAnimalsQuery
import com.laamile.animalzukan.common.model.AnimalModel
import com.laamile.animalzukan.common.model.DetailAnimalModel

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

fun GetAnimalByIDQuery.Data.toDetailAnimalModel(): DetailAnimalModel {
    return DetailAnimalModel(
        animalID = this.animalByID?.animalID ?: "",
        commonName = this.animalByID?.commonName ?: "",
        scientificName = this.animalByID?.scientificName ?: "",
        description = this.animalByID?.description ?: "",
        soundURL = this.animalByID?.soundURL ?: "",
        imageURL = this.animalByID?.imageURL ?: "",
        habitat = this.animalByID?.habitat ?: "",
        diet = this.animalByID?.diet ?: "",
        lifespan = this.animalByID?.lifespan ?: "",
        conservationStatus = this.animalByID?.conservationStatus ?: ""
    )
}
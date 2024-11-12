package com.laamile.animalzukan.util

import com.laamile.animalzukan.GetAnimalByIDQuery
import com.laamile.animalzukan.db.AnimalEntity

fun GetAnimalByIDQuery.Data.toAnimalEntity(): AnimalEntity {
    return AnimalEntity(
        animalID = this.animalByID?.animalID ?: "",
        commonName = this.animalByID?.commonName ?: "",
        scientificName = this.animalByID?.scientificName ?: "",
        description = this.animalByID?.description ?: "",
        imageURL = this.animalByID?.imageURL ?: ""
    )
}
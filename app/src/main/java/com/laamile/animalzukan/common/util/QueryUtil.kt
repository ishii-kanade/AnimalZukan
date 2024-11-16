package com.laamile.animalzukan.common.util

import com.laamile.animalzukan.GetAnimalByIDQuery
import com.laamile.animalzukan.common.db.AnimalEntity

fun GetAnimalByIDQuery.Data.toAnimalEntity(): AnimalEntity {
    return AnimalEntity(
        animalID = this.animalByID?.animalID ?: "",
        commonName = this.animalByID?.commonName ?: "",
        scientificName = this.animalByID?.scientificName ?: "",
        description = this.animalByID?.description ?: "",
        imageURL = this.animalByID?.imageURL ?: ""
    )
}
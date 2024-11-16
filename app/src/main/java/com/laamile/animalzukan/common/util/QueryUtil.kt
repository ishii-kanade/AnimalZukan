package com.laamile.animalzukan.common.util

import com.laamile.animalzukan.GetAnimalByIDQuery
import com.laamile.animalzukan.common.db.AnimalEntity
import com.laamile.animalzukan.common.model.DetailAnimalModel

fun DetailAnimalModel.toAnimalEntity(): AnimalEntity {
    return AnimalEntity(
        animalID = this.animalID,
        commonName = this.commonName,
        scientificName = this.scientificName,
        description = this.description,
        imageURL = this.imageURL
    )
}
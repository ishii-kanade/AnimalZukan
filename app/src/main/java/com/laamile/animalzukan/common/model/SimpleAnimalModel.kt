package com.laamile.animalzukan.common.model

data class SimpleAnimalModel(
    override val animalID: String,
    override val commonName: String,
    override val scientificName: String,
    override val imageURL: String
): AnimalModel(animalID, commonName, scientificName, imageURL)
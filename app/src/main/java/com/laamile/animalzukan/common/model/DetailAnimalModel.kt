package com.laamile.animalzukan.common.model

data class DetailAnimalModel (
    val animalID: String,
    val commonName: String,
    val scientificName: String,
    val description: String,
    val soundURL: String,
    val imageURL: String,
    val habitat: String,
    val diet: String,
    val lifespan: String,
    val conservationStatus: String
)
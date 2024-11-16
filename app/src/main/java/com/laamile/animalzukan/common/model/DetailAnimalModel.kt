package com.laamile.animalzukan.common.model

data class DetailAnimalModel(
    override val animalID: String,
    override val commonName: String,
    override val scientificName: String,
    override val imageURL: String,
    val description: String,
    val soundURL: String,
    val habitat: String,
    val diet: String,
    val lifespan: String,
    val conservationStatus: String,
) : AnimalModel(animalID, commonName, scientificName, imageURL)
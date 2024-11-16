package com.laamile.animalzukan.common.model

sealed class AnimalModel(
    open val animalID: String,
    open val commonName: String,
    open val scientificName: String,
    open val imageURL: String
)
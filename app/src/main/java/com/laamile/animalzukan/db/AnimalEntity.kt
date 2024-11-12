package com.laamile.animalzukan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_animals")
data class AnimalEntity(
    @PrimaryKey val animalID: String,
    val commonName: String,
    val scientificName: String,
    val description: String,
    val imageURL: String
)

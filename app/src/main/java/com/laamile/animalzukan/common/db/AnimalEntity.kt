package com.laamile.animalzukan.common.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.laamile.animalzukan.common.model.AnimalModel

@Entity(tableName = "favorite_animals")
data class AnimalEntity(
    @PrimaryKey val animalID: String,
    val commonName: String,
    val scientificName: String,
    val description: String,
    val imageURL: String
) {
    // 通常の data class への変換
    fun toAnimal() = AnimalModel(animalID, commonName, scientificName, imageURL)
}

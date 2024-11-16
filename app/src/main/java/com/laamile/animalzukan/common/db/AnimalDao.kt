package com.laamile.animalzukan.common.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimalDao {
    @Insert
    suspend fun insertFavorite(animal: AnimalEntity)

    @Delete
    suspend fun deleteFavorite(animal: AnimalEntity)

    @Query("SELECT * FROM favorite_animals")
    suspend fun getAllFavorites(): List<AnimalEntity>

    @Query("SELECT * FROM favorite_animals WHERE animalID = :animalID LIMIT 1")
    suspend fun getFavoriteById(animalID: String): AnimalEntity?
}
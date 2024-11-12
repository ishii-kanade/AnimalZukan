package com.laamile.animalzukan.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laamile.animalzukan.db.AnimalDao
import com.laamile.animalzukan.db.AnimalEntity

@Database(entities = [AnimalEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}

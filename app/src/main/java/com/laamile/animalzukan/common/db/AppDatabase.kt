package com.laamile.animalzukan.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laamile.animalzukan.common.db.AnimalDao
import com.laamile.animalzukan.common.db.AnimalEntity

@Database(entities = [AnimalEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}

package com.laamile.animalzukan.di

import android.content.Context
import androidx.room.Room
import com.laamile.animalzukan.db.AnimalDao
import com.laamile.animalzukan.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "animal_database"
        ).build()
    }

    @Provides
    fun provideAnimalDao(appDatabase: AppDatabase): AnimalDao {
        return appDatabase.animalDao()
    }
}

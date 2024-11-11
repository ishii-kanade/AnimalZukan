package com.laamile.animalzukan.di

import com.laamile.animalzukan.infra.repository.AnimalRepository
import com.laamile.animalzukan.infra.repository.AnimalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAnimalRepository(
        impl: AnimalRepositoryImpl
    ): AnimalRepository
}
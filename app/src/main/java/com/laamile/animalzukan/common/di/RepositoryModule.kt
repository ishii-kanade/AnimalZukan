package com.laamile.animalzukan.common.di

import com.laamile.animalzukan.common.infra.repository.AnimalRepository
import com.laamile.animalzukan.common.infra.repository.AnimalRepositoryImpl
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
package com.laamile.animalzukan.common.di

import com.laamile.animalzukan.common.infra.usecase.GetAnimalByIDUseCase
import com.laamile.animalzukan.common.infra.usecase.GetAnimalByIDUseCaseImpl
import com.laamile.animalzukan.common.infra.usecase.GetAnimalsUseCase
import com.laamile.animalzukan.common.infra.usecase.GetAnimalsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetAnimalsUseCase(
        impl: GetAnimalsUseCaseImpl
    ): GetAnimalsUseCase

    @Binds
    @Singleton
    abstract fun bindGetAnimalByIDUseCase(
        impl: GetAnimalByIDUseCaseImpl
    ): GetAnimalByIDUseCase
}

package com.laamile.animalzukan.common.di

import com.apollographql.apollo3.ApolloClient
import com.laamile.animalzukan.common.infra.AnimalZukanApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://go-graphql-server-side.vercel.app/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideAnimalZukanApolloClient(apolloClient: ApolloClient): AnimalZukanApolloClient {
        return AnimalZukanApolloClient(apolloClient)
    }
}



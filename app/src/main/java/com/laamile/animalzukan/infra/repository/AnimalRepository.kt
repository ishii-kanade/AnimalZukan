package com.laamile.animalzukan.infra.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.laamile.animalzukan.GetAnimalsQuery

interface AnimalRepository {
    suspend fun getAnimals(limit: Int): ApolloResponse<GetAnimalsQuery.Data>?
}



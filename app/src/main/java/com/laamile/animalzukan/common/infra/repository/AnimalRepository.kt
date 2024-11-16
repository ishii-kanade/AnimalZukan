package com.laamile.animalzukan.common.infra.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.laamile.animalzukan.GetAnimalByIDQuery
import com.laamile.animalzukan.GetAnimalsQuery

interface AnimalRepository {
    suspend fun getAnimals(limit: Int): ApolloResponse<GetAnimalsQuery.Data>?
    suspend fun getAnimalById(id: String): ApolloResponse<GetAnimalByIDQuery.Data>?
}



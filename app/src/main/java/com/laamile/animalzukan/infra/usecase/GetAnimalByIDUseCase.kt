package com.laamile.animalzukan.infra.usecase

import com.apollographql.apollo3.api.ApolloResponse
import com.laamile.animalzukan.GetAnimalByIDQuery

interface GetAnimalByIDUseCase {
    suspend operator fun invoke(animalId: String): ApolloResponse<GetAnimalByIDQuery.Data>?
}
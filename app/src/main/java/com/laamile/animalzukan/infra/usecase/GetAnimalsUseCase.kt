package com.laamile.animalzukan.infra.usecase

import com.apollographql.apollo3.api.ApolloResponse
import com.laamile.animalzukan.GetAnimalsQuery

interface GetAnimalsUseCase {
    suspend operator fun invoke(limit: Int): ApolloResponse<GetAnimalsQuery.Data>?
}

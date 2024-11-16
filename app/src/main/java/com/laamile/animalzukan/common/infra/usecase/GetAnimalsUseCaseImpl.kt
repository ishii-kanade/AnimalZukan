package com.laamile.animalzukan.common.infra.usecase

import com.apollographql.apollo3.api.ApolloResponse
import com.laamile.animalzukan.GetAnimalsQuery
import com.laamile.animalzukan.common.infra.repository.AnimalRepository
import javax.inject.Inject

class GetAnimalsUseCaseImpl @Inject constructor(
    private val animalRepository: AnimalRepository
) : GetAnimalsUseCase {
    override suspend fun invoke(limit: Int): ApolloResponse<GetAnimalsQuery.Data>? {
        return animalRepository.getAnimals(limit)
    }
}

package com.laamile.animalzukan.infra.usecase

import com.apollographql.apollo3.api.ApolloResponse
import com.laamile.animalzukan.GetAnimalsQuery
import com.laamile.animalzukan.infra.repository.AnimalRepository
import javax.inject.Inject

class GetAnimalsUseCaseImpl @Inject constructor(
    private val animalRepository: AnimalRepository
) : GetAnimalsUseCase {
    override suspend fun invoke(limit: Int): ApolloResponse<GetAnimalsQuery.Data>? {
        return animalRepository.getAnimals(limit)
    }
}

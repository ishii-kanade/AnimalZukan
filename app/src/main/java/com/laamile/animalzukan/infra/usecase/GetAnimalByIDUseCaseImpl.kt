package com.laamile.animalzukan.infra.usecase

import com.apollographql.apollo3.api.ApolloResponse
import com.laamile.animalzukan.GetAnimalByIDQuery
import com.laamile.animalzukan.infra.repository.AnimalRepository
import javax.inject.Inject

class GetAnimalByIDUseCaseImpl @Inject constructor(
    private val animalRepository: AnimalRepository
) : GetAnimalByIDUseCase {
    override suspend fun invoke(animalId: String): ApolloResponse<GetAnimalByIDQuery.Data>? {
        return animalRepository.getAnimalById(animalId)
    }
}
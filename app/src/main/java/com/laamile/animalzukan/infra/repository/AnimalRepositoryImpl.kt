package com.laamile.animalzukan.infra.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.exception.ApolloException
import com.laamile.animalzukan.AnimalZukanApolloClient
import com.laamile.animalzukan.GetAnimalByIDQuery
import com.laamile.animalzukan.GetAnimalsQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AnimalRepositoryImpl @Inject constructor(
    private val apolloClient: AnimalZukanApolloClient
) : AnimalRepository {
    override suspend fun getAnimals(limit: Int): ApolloResponse<GetAnimalsQuery.Data>? {
        return try {
            withContext(Dispatchers.IO) {
                apolloClient.client.query(GetAnimalsQuery(limit)).execute()
            }
        } catch (e: ApolloException) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getAnimalById(id: String): ApolloResponse<GetAnimalByIDQuery.Data>? {
        return try {
            withContext(Dispatchers.IO) {
                apolloClient.client.query(GetAnimalByIDQuery(id)).execute()
            }
        } catch (e: ApolloException) {
            e.printStackTrace()
            null
        }
    }
}

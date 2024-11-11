package com.laamile.animalzukan

import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.exception.ApolloException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AnimalRepository @Inject constructor(
    private val apolloClient: AnimalZukanApolloClient
) {
    suspend fun getAnimals(limit: Int): ApolloResponse<GetAnimalsQuery.Data>? {
        return try {
            withContext(Dispatchers.IO) {
                apolloClient.client.query(GetAnimalsQuery(limit)).execute()
            }
        } catch (e: ApolloException) {
            e.printStackTrace()
            null
        }
    }
}


package com.laamile.animalzukan

import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.exception.ApolloException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimalRepository {
    private val apolloClient = AnimalZukanApolloClient.client

    suspend fun getAnimals(limit: Int): ApolloResponse<GetAnimalsQuery.Data>? {
        return try {
            withContext(Dispatchers.IO) {
                apolloClient.query(GetAnimalsQuery(limit)).execute()
            }
        } catch (e: ApolloException) {
            e.printStackTrace()
            null
        }
    }
}

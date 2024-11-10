package com.laamile.animalzukan
import com.apollographql.apollo3.ApolloClient

object AnimalZukanApolloClient {
    val client = ApolloClient.Builder()
        .serverUrl("https://go-graphql-server-side.vercel.app/graphql")
        .build()
}
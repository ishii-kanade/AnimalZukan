package com.laamile.animalzukan.navigation

object NavRoutes {
    const val ANIMAL_LIST = "animal_list"
    const val ANIMAL_DETAIL = "animal_detail/{animalId}"

    // Argument keys
    const val ANIMAL_ID_KEY = "animalId"

    // Helper function for generating detail route
    fun animalDetailRoute(animalId: String) = "animal_detail/$animalId"
}

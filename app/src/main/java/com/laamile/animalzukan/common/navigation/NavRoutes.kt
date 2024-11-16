package com.laamile.animalzukan.common.navigation

object NavRoutes {
    const val ANIMAL_LIST = "animal_list" // ホーム画面のルート
    const val FAVORITE_LIST = "favorite_list" // お気に入り画面のルート
    const val ANIMAL_DETAIL = "animal_detail/{animalId}"

    // Argument keys
    const val ANIMAL_ID_KEY = "animalId"

    // Helper function for generating detail route
    fun animalDetailRoute(animalId: String) = "animal_detail/$animalId"
}

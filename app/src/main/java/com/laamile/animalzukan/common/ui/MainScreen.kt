package com.laamile.animalzukan.common.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.laamile.animalzukan.feature.home.AnimalListScreen
import com.laamile.animalzukan.common.navigation.BottomNavigationBar
import com.laamile.animalzukan.common.navigation.NavRoutes
import com.laamile.animalzukan.feature.detail.AnimalDetailScreen
import com.laamile.animalzukan.feature.favorite.FavoriteAnimalsScreen

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(bottomBar = {
        BottomNavigationBar(navController)
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.ANIMAL_LIST,
            modifier = Modifier.padding(innerPadding) // modifierを明示的に指定
        ) {
            composable(NavRoutes.ANIMAL_LIST) {
                AnimalListScreen(onAnimalClick = { animalId ->
                    navController.navigate(NavRoutes.animalDetailRoute(animalId))
                })
            }
            composable(NavRoutes.FAVORITE_LIST) {
                FavoriteAnimalsScreen(onAnimalClick = { animalId ->
                    navController.navigate(NavRoutes.animalDetailRoute(animalId))
                })
            }
            composable(
                NavRoutes.ANIMAL_DETAIL, arguments = listOf(navArgument(NavRoutes.ANIMAL_ID_KEY) {
                    type = NavType.StringType
                })
            ) { backStackEntry ->
                val animalId = backStackEntry.arguments?.getString(NavRoutes.ANIMAL_ID_KEY)
                AnimalDetailScreen(animalId = animalId)
            }
        }
    }
}

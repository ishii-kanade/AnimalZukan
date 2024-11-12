package com.laamile.animalzukan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.laamile.animalzukan.navigation.NavRoutes
import com.laamile.animalzukan.ui.theme.AnimalZukanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            AnimalZukanTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = NavRoutes.ANIMAL_LIST,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        // AnimalListScreen のルート
                        composable(NavRoutes.ANIMAL_LIST) {
                            AnimalListScreen(onAnimalClick = { animalId ->
                                navController.navigate(NavRoutes.animalDetailRoute(animalId))
                            })
                        }
                        // AnimalDetailScreen のルート
                        composable(
                            NavRoutes.ANIMAL_DETAIL,
                            arguments = listOf(navArgument(NavRoutes.ANIMAL_ID_KEY) {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val animalId =
                                backStackEntry.arguments?.getString(NavRoutes.ANIMAL_ID_KEY)
                            AnimalDetailScreen(animalId = animalId)
                        }
                    }
                }
            }
        }
    }
}


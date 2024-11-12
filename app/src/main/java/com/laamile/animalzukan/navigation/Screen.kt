package com.laamile.animalzukan.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen(NavRoutes.ANIMAL_LIST, "Home", Icons.Default.Home)
    object Favorites : Screen(NavRoutes.FAVORITE_LIST, "Favorites", Icons.Default.Favorite)
}

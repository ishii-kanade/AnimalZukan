package com.laamile.animalzukan.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.laamile.animalzukan.common.ui.MainScreen
import com.laamile.animalzukan.ui.theme.AnimalZukanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()
            val navController = rememberNavController()
            AnimalZukanTheme {
                MainScreen(navController)
            }
        }
    }
}


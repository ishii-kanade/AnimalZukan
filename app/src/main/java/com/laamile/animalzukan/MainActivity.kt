package com.laamile.animalzukan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.laamile.animalzukan.ui.theme.AnimalZukanTheme

class MainActivity : ComponentActivity() {
    private val animalRepository = AnimalRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalZukanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AnimalListScreen(
                        modifier = Modifier.padding(innerPadding),
                        animalRepository = animalRepository
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimalZukanTheme {
        Greeting("Android")
    }
}
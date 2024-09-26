package com.example.demiurge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.demiurge.ui.navigation.Navigation
import com.example.demiurge.ui.navigation.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationController = rememberNavController()
            Navigation(
                navigationController = navigationController,
                startDestination = Screens.Splash.screen
            )
        }
    }
}

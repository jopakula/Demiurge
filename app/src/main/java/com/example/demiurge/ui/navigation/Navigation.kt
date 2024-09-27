package com.example.demiurge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.demiurge.ui.screens.MainScreen
import com.example.demiurge.ui.screens.SplashScreen
import com.example.demiurge.ui.screens.TestScreen

@Composable
fun Navigation(
    navigationController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navigationController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screens.Splash.screen) { SplashScreen(navigationController = navigationController)}
        composable(Screens.Main.screen) { MainScreen(navigationController = navigationController)}
        composable(Screens.Test.screen) { TestScreen() }
    }

}
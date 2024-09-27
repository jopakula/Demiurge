package com.example.demiurge.ui.navigation

sealed class Screens (
    val screen: String
){
    data object Splash: Screens("splash")
    data object Main: Screens("main")
    data object Test: Screens("test")
}
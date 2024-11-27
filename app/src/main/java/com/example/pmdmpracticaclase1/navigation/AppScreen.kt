package com.example.pmdmpracticaclase1.navigation

sealed class AppScreen(val route: String) {
    // Hacemos un object en el que declaramos la primera pantalla
    object FirstScreen: AppScreen("FirstScreen")
    // Hacemos un object en el que declaramos la segunda pantalla
    object SecondScreen: AppScreen("SecondScreen")
}
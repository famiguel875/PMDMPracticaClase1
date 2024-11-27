package com.example.pmdmpracticaclase1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdmpracticaclase1.screens.FirstScreen
import com.example.pmdmpracticaclase1.screens.SecondScreen

@Composable
fun AppNavigation() {
    // Creamos un controlador de navegación en el que guardamos el estado
    val navController = rememberNavController()

    // Declaramos el navHost, dentro de este declaramos el controller y que empiece en la primera pantalla
    NavHost(
        navController = navController,
        startDestination = AppScreen.FirstScreen.route
    ) {
        // Composable para la FirstScreen
        composable(AppScreen.FirstScreen.route) {
            FirstScreen(navController)
        }

        // Composable para la SecondScreen, pasamos la ruta con todos los argumentos utilizados y sus valores por defecto
        composable(
            route = AppScreen.SecondScreen.route + "/{text}/{number}/{isBoolean}/{decimal}",
            arguments = listOf(
                navArgument("text") { type = NavType.StringType; defaultValue = "Texto vacío" },
                navArgument("number") { type = NavType.IntType; defaultValue = 0 },
                navArgument("isBoolean") { type = NavType.BoolType; defaultValue = false },
                navArgument("decimal") { type = NavType.FloatType; defaultValue = 0.0f }
            )
        ) {
            // Pasamos los argumentos enviados a la SecondScreen
            val textArg = it.arguments?.getString("text")
            val numberArg = it.arguments?.getInt("number")
            val isBooleanArg = it.arguments?.getBoolean("isBoolean")
            val decimalArg = it.arguments?.getFloat("decimal")

            // Realizamos llamada a la SecondScreen
            SecondScreen(
                navController = navController,
                texto = textArg,
                number = numberArg,
                isBoolean = isBooleanArg,
                decimal = decimalArg
            )
        }
    }
}

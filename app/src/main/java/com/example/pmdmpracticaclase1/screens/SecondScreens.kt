package com.example.pmdmpracticaclase1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Pasamos la lógica del body a la pantalla, con todos los parámetros
@Composable
fun SecondScreen(navController: NavController, texto: String?, number: Int?, isBoolean: Boolean?, decimal: Float?) {
    SecondBody(navController, texto, number, isBoolean, decimal)
}

@Composable
fun SecondBody(navController: NavController, text: String?, number: Int?, isBoolean: Boolean?, decimal: Float?) {
    // Hacemos que la columna utilice un modifier que haga que ocupe toda la pantalla,
    // que los elementos se alineen al centro verticalmente y que la columna este alineada
    // horizontalmente al centro
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón volver para regresar a FirstScreen
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Volver")
        }

        // Texto que muestran los datos recibidos de la FirstScreen o los valores por defecto en caso de envio nulo/en blanco
        Text(
            text = "Texto recibido: ${text ?: "No hay datos recibidos"}",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Número recibido: ${number ?: "No hay datos recibidos"}",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Booleano recibido: ${isBoolean ?: "No hay datos recibidos"}",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Decimal recibido: ${decimal ?: "No hay datos recibidosl"}",
            modifier = Modifier.padding(8.dp)
        )
    }
}
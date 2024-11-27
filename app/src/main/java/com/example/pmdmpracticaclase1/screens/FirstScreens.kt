package com.example.pmdmpracticaclase1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pmdmpracticaclase1.navigation.AppScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp

// Pasamos la lógica del body a la pantalla
@Composable
fun FirstScreen(navController: NavController) {
    FirstBody(navController)
}

@Composable
fun FirstBody(navController: NavController) {
    // Metemos remember para capturar los estados de los parámetros
    val textInput = remember { mutableStateOf("") }
    val numberInput = remember { mutableStateOf("") }
    val booleanInput = remember { mutableStateOf("") }
    val decimalInput = remember { mutableStateOf("") }

    // Hacemos que la columna utilice un modifier que haga que ocupe toda la pantalla,
    // que los elementos se alineen al centro verticalmente y que la columna este alineada
    // horizontalmente al centro
    Column(
        modifier = Modifier.fillMaxSize(), // Ocupar toda la pantalla
        verticalArrangement = Arrangement.Center, // Alinear elementos verticalmente al centro
        horizontalAlignment = Alignment.CenterHorizontally // Alinear horizontalmente al centro
    ) {
        // TextField para capturar el valor del String
        OutlinedTextField(
            value = textInput.value,
            onValueChange = { textInput.value = it },
            label = { Text("Introduce un texto") },
            modifier = Modifier.padding(8.dp)
        )

        // TextField para capturar el valor del Int
        OutlinedTextField(
            value = numberInput.value,
            onValueChange = { numberInput.value = it },
            label = { Text("Introduce un número entero") },
            modifier = Modifier.padding(8.dp)
        )

        // TextField para capturar el valor del Boolean
        OutlinedTextField(
            value = booleanInput.value,
            onValueChange = { booleanInput.value = it },
            label = { Text("Introduce true/false") },
            modifier = Modifier.padding(8.dp)
        )

        // TextField para capturar el valor del Float
        OutlinedTextField(
            value = decimalInput.value,
            onValueChange = { decimalInput.value = it },
            label = { Text("Introduce un número decimal") },
            modifier = Modifier.padding(8.dp)
        )

        // Botón que utilizamos para enviar los datos
        Button(
            onClick = {
                // Validamos las entradas y damos valores por defecto en caso de envio nulo/en blanco
                val validatedNumber = numberInput.value.toIntOrNull() ?: 0
                val validatedBoolean = booleanInput.value.toBooleanStrictOrNull() ?: false
                val validatedDecimal = decimalInput.value.toFloatOrNull() ?: 0.0f
                val validatedText = textInput.value.ifBlank { "No hay datos recibidos" }

                // Enviamos la ruta con los valores validados
                navController.navigate(
                    route = AppScreen.SecondScreen.route +
                            "/$validatedText/$validatedNumber/$validatedBoolean/$validatedDecimal"
                )
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Enviar")
        }
    }
}



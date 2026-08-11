package com.jesusdmedinac.sexplay.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel

@Composable
fun SetupScreen(
    onStartGame: (String, String, IntensityLevel) -> Unit
) {
    var player1Name by remember { mutableStateOf("Jugador 1") }
    var player2Name by remember { mutableStateOf("Jugador 2") }
    var selectedIntensity by remember { mutableStateOf(IntensityLevel.MEDIUM) }
    
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Sex Play", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))
        
        OutlinedTextField(
            value = player1Name,
            onValueChange = { player1Name = it },
            label = { Text("Nombre Jugador 1") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = player2Name,
            onValueChange = { player2Name = it },
            label = { Text("Nombre Jugador 2") }
        )
        Spacer(modifier = Modifier.height(32.dp))
        
        Text("Nivel Máximo de Intensidad (Castigos)")
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IntensityLevel.entries.forEach { level ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = selectedIntensity == level,
                        onClick = { selectedIntensity = level }
                    )
                    Text(text = level.level.toString())
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { onStartGame(player1Name, player2Name, selectedIntensity) },
            modifier = Modifier.fillMaxWidth(0.8f).height(56.dp)
        ) {
            Text("Empezar Juego")
        }
    }
}

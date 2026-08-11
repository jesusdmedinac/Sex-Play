package com.jesusdmedinac.sexplay.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel
import com.jesusdmedinac.sexplay.domain.model.state.GameState

@Composable
fun SetupWizardStep1(
    state: GameState.SetupStep1,
    onNext: (String, String) -> Unit
) {
    var player1Name by remember { mutableStateOf(state.player1Name) }
    var player2Name by remember { mutableStateOf(state.player2Name) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Paso 1 de 3: Perfiles", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
        Text("¿Quiénes juegan hoy?", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = player1Name,
            onValueChange = { player1Name = it },
            label = { Text("Nombre Jugador 1") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = player2Name,
            onValueChange = { player2Name = it },
            label = { Text("Nombre Jugador 2") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { onNext(player1Name, player2Name) },
            modifier = Modifier.fillMaxWidth(0.8f).height(56.dp)
        ) {
            Text("Siguiente: Elige el Vibe ➔")
        }
    }
}

@Composable
fun SetupWizardStep2(
    state: GameState.SetupStep2,
    onBack: () -> Unit,
    onNext: (GameMood, IntensityLevel) -> Unit
) {
    var selectedMood by remember { mutableStateOf(state.selectedMood) }
    var selectedIntensity by remember { mutableStateOf(state.maxIntensity) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Paso 2 de 3: Ambiente & Intensidad", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Selecciona el Mood de las Cartas:", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))

        GameMood.entries.forEach { mood ->
            FilterChip(
                selected = selectedMood == mood,
                onClick = { selectedMood = mood },
                label = { Text(mood.displayName) },
                modifier = Modifier.fillMaxWidth(0.8f).padding(vertical = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Nivel Máximo de Castigo:", style = MaterialTheme.typography.titleSmall)
        Row(
            modifier = Modifier.fillMaxWidth(0.8f).padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IntensityLevel.entries.forEach { level ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    RadioButton(
                        selected = selectedIntensity == level,
                        onClick = { selectedIntensity = level }
                    )
                    Text("Nivel ${level.level}")
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(onClick = { onNext(selectedMood, selectedIntensity) }) {
                Text("Siguiente: Seguridad ➔")
            }
        }
    }
}

@Composable
fun SetupWizardStep3(
    state: GameState.SetupStep3,
    onBack: () -> Unit,
    onFinish: (String, Set<HardLimit>) -> Unit
) {
    var safeWord by remember { mutableStateOf(state.safeWord) }
    var selectedLimits by remember { mutableStateOf(state.selectedHardLimits) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Paso 3 de 3: Consentimiento & Seguridad", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = safeWord,
            onValueChange = { safeWord = it },
            label = { Text("Palabra de Seguridad (Safe Word)") },
            placeholder = { Text("Ej. Rojo, Piña, Parar") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text("Límites Duros (Excluir categorías del mazo):", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))

        HardLimit.entries.forEach { limit ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.8f).padding(vertical = 4.dp)
            ) {
                Checkbox(
                    checked = selectedLimits.contains(limit),
                    onCheckedChange = { isChecked ->
                        selectedLimits = if (isChecked) {
                            selectedLimits + limit
                        } else {
                            selectedLimits - limit
                        }
                    }
                )
                Text(limit.displayName, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(
                onClick = { onFinish(safeWord, selectedLimits) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("¡Comenzar Partida! 🔥")
            }
        }
    }
}

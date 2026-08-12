package com.jesusdmedinac.sexplay.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jesusdmedinac.sexplay.domain.model.GameMode
import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel
import com.jesusdmedinac.sexplay.domain.model.state.GameState

@Composable
fun SetupStep1NamesScreen(
    state: GameState.SetupStep1Names,
    onNext: (String, String) -> Unit
) {
    var player1Name by remember { mutableStateOf(state.player1Name) }
    var player2Name by remember { mutableStateOf(state.player2Name) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¿Cómo se llaman?", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = player1Name,
            onValueChange = { player1Name = it },
            label = { Text("Nombre Jugador 1") },
            modifier = Modifier.fillMaxWidth(0.85f)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = player2Name,
            onValueChange = { player2Name = it },
            label = { Text("Nombre Jugador 2") },
            modifier = Modifier.fillMaxWidth(0.85f)
        )
        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { onNext(player1Name, player2Name) },
            modifier = Modifier.fillMaxWidth(0.85f).height(56.dp)
        ) {
            Text("Siguiente ➔")
        }
    }
}

@Composable
fun SetupStep2LocationScreen(
    state: GameState.SetupStep2Location,
    onBack: () -> Unit,
    onNext: (Boolean) -> Unit
) {
    var isRemote by remember { mutableStateOf(state.isRemote) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¿Dónde van a jugar hoy?", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        FilterChip(
            selected = !isRemote,
            onClick = { isRemote = false },
            label = { Text("🏡 En Persona (Mismo Dispositivo)") },
            modifier = Modifier.fillMaxWidth(0.85f).padding(vertical = 8.dp)
        )

        FilterChip(
            selected = isRemote,
            onClick = { isRemote = true },
            label = { Text("🌐 Modo a Distancia / Remoto (Sin contacto presencial)") },
            modifier = Modifier.fillMaxWidth(0.85f).padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(onClick = { onNext(isRemote) }) {
                Text("Siguiente ➔")
            }
        }
    }
}

@Composable
fun SetupStep3DurationScreen(
    state: GameState.SetupStep3Duration,
    onBack: () -> Unit,
    onNext: (GameMode) -> Unit
) {
    var selectedGameMode by remember { mutableStateOf(state.gameMode) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¿Cuánto tiempo tienen?", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        GameMode.entries.forEach { mode ->
            FilterChip(
                selected = selectedGameMode == mode,
                onClick = { selectedGameMode = mode },
                label = { Text(mode.displayName) },
                modifier = Modifier.fillMaxWidth(0.85f).padding(vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(onClick = { onNext(selectedGameMode) }) {
                Text("Siguiente ➔")
            }
        }
    }
}

@Composable
fun SetupStep4MoodScreen(
    state: GameState.SetupStep4Mood,
    onBack: () -> Unit,
    onNext: (GameMood) -> Unit
) {
    var selectedMood by remember { mutableStateOf(state.selectedMood) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¿Qué ambiente prefieren hoy?", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        GameMood.entries.forEach { mood ->
            FilterChip(
                selected = selectedMood == mood,
                onClick = { selectedMood = mood },
                label = { Text(mood.displayName) },
                modifier = Modifier.fillMaxWidth(0.85f).padding(vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(onClick = { onNext(selectedMood) }) {
                Text("Siguiente ➔")
            }
        }
    }
}

@Composable
fun SetupStep5IntensityScreen(
    state: GameState.SetupStep5Intensity,
    onBack: () -> Unit,
    onNext: (IntensityLevel) -> Unit
) {
    var selectedIntensity by remember { mutableStateOf(state.maxIntensity) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¿Nivel máximo de castigo?", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        IntensityLevel.entries.forEach { level ->
            FilterChip(
                selected = selectedIntensity == level,
                onClick = { selectedIntensity = level },
                label = { Text(level.displayName) },
                modifier = Modifier.fillMaxWidth(0.85f).padding(vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(onClick = { onNext(selectedIntensity) }) {
                Text("Siguiente ➔")
            }
        }
    }
}

@Composable
fun SetupStep6LimitsScreen(
    state: GameState.SetupStep6Limits,
    onBack: () -> Unit,
    onNext: (Set<HardLimit>) -> Unit
) {
    var selectedLimits by remember { mutableStateOf(state.selectedHardLimits) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¿Límites a excluir?", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Text("(Opcional)", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
        Spacer(modifier = Modifier.height(32.dp))

        HardLimit.entries.filter { it != HardLimit.PHYSICAL_CONTACT }.forEach { limit ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.85f).padding(vertical = 6.dp)
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
                Text(limit.displayName, style = MaterialTheme.typography.bodyLarge)
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(onClick = { onNext(selectedLimits) }) {
                Text("Siguiente ➔")
            }
        }
    }
}

@Composable
fun SetupStep7SafeWordScreen(
    state: GameState.SetupStep7SafeWord,
    onBack: () -> Unit,
    onFinish: (String) -> Unit
) {
    var safeWord by remember { mutableStateOf(state.safeWord) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Palabra de Seguridad", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = safeWord,
            onValueChange = { safeWord = it },
            label = { Text("Safe Word") },
            placeholder = { Text("Ej. Rojo, Piña, Parar") },
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack) {
                Text("⬅ Atrás")
            }
            Button(
                onClick = { onFinish(safeWord) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("¡Comenzar Partida! 🔥")
            }
        }
    }
}

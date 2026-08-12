package com.jesusdmedinac.sexplay.presentation.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jesusdmedinac.sexplay.domain.model.GameMode
import com.jesusdmedinac.sexplay.domain.model.GameMood
import com.jesusdmedinac.sexplay.domain.model.HardLimit
import com.jesusdmedinac.sexplay.domain.model.IntensityLevel
import com.jesusdmedinac.sexplay.domain.model.state.GameState
import com.jesusdmedinac.sexplay.presentation.theme.ExpressiveButtonShape

@Composable
private fun ExpressiveOptionCard(
    selected: Boolean,
    onClick: () -> Unit,
    title: String,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = when {
            isPressed -> 0.96f
            selected -> 1.02f
            else -> 1.0f
        },
        animationSpec = spring(
            stiffness = Spring.StiffnessMediumLow,
            dampingRatio = Spring.DampingRatioMediumBouncy
        )
    )

    val animatedContainerColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceContainerLow
    )

    val animatedContentColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
    )

    Surface(
        modifier = modifier
            .fillMaxWidth(0.85f)
            .padding(vertical = 6.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            },
        shape = RoundedCornerShape(20.dp),
        color = animatedContainerColor,
        shadowElevation = if (selected) 12.dp else 2.dp
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                color = animatedContentColor
            )
        }
    }
}

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
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(0.85f)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = player2Name,
            onValueChange = { player2Name = it },
            label = { Text("Nombre Jugador 2") },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(0.85f)
        )
        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { onNext(player1Name, player2Name) },
            shape = ExpressiveButtonShape,
            modifier = Modifier.fillMaxWidth(0.85f).height(56.dp)
        ) {
            Text("Siguiente")
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

        ExpressiveOptionCard(
            selected = !isRemote,
            onClick = { isRemote = false },
            title = "En Persona (Mismo Dispositivo)"
        )

        ExpressiveOptionCard(
            selected = isRemote,
            onClick = { isRemote = true },
            title = "Modo a Distancia / Remoto (Sin contacto presencial)"
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack, shape = ExpressiveButtonShape) {
                Text("Atrás")
            }
            Button(onClick = { onNext(isRemote) }, shape = ExpressiveButtonShape) {
                Text("Siguiente")
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
            ExpressiveOptionCard(
                selected = selectedGameMode == mode,
                onClick = { selectedGameMode = mode },
                title = mode.displayName
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack, shape = ExpressiveButtonShape) {
                Text("Atrás")
            }
            Button(onClick = { onNext(selectedGameMode) }, shape = ExpressiveButtonShape) {
                Text("Siguiente")
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
            ExpressiveOptionCard(
                selected = selectedMood == mood,
                onClick = { selectedMood = mood },
                title = mood.displayName
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack, shape = ExpressiveButtonShape) {
                Text("Atrás")
            }
            Button(onClick = { onNext(selectedMood) }, shape = ExpressiveButtonShape) {
                Text("Siguiente")
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
            ExpressiveOptionCard(
                selected = selectedIntensity == level,
                onClick = { selectedIntensity = level },
                title = level.displayName
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack, shape = ExpressiveButtonShape) {
                Text("Atrás")
            }
            Button(onClick = { onNext(selectedIntensity) }, shape = ExpressiveButtonShape) {
                Text("Siguiente")
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
            val isSelected = selectedLimits.contains(limit)
            ExpressiveOptionCard(
                selected = isSelected,
                onClick = {
                    selectedLimits = if (isSelected) {
                        selectedLimits - limit
                    } else {
                        selectedLimits + limit
                    }
                },
                title = limit.displayName
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack, shape = ExpressiveButtonShape) {
                Text("Atrás")
            }
            Button(onClick = { onNext(selectedLimits) }, shape = ExpressiveButtonShape) {
                Text("Siguiente")
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
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(0.85f)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onBack, shape = ExpressiveButtonShape) {
                Text("Atrás")
            }
            Button(
                onClick = { onFinish(safeWord) },
                shape = ExpressiveButtonShape,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("¡Comenzar Partida!")
            }
        }
    }
}

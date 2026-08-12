package com.jesusdmedinac.sexplay.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jesusdmedinac.sexplay.domain.model.state.GameState
import com.jesusdmedinac.sexplay.presentation.theme.ExpressiveAsymmetricCardShape
import com.jesusdmedinac.sexplay.presentation.theme.ExpressiveButtonShape

private fun formatDuration(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return if (mins > 0) "${mins}m ${secs}s" else "${secs}s"
}

@Composable
fun WinnerChoiceScreen(
    state: GameState.WinnerChoice,
    onSelectConsequence: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¡Juego Terminado!", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))

        if (state.isSharedVictory) {
            Text(
                text = "¡Completaron el juego juntos!",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Resistencia compartida. Ambos ganan un premio.", style = MaterialTheme.typography.bodyLarge)
        } else {
            Text("${state.loserName} no aguantó más.", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "¡${state.winnerName} Gana!",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Elige tu destino:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onSelectConsequence(true) }, shape = ExpressiveButtonShape) {
                Text("Recibir Premio")
            }
            if (!state.isSharedVictory) {
                Button(
                    onClick = { onSelectConsequence(false) },
                    shape = ExpressiveButtonShape,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Aplicar Castigo")
                }
            }
        }
    }
}

@Composable
fun ResolutionScreen(
    state: GameState.Resolution,
    onPlayAgain: () -> Unit
) {
    var showConsequenceDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (state.isReward) "Premio para ${state.winnerName}" else "Castigo para ${state.loserName}",
            style = MaterialTheme.typography.titleLarge,
            color = if (state.isReward) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(220.dp)
                .clickable { showConsequenceDialog = true },
            shape = ExpressiveAsymmetricCardShape,
            colors = CardDefaults.cardColors(
                containerColor = if (state.isReward) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.errorContainer
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = state.consequenceTitle,
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Toca para ver instrucciones completas",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Session Statistics Display
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainerHigh,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(0.85f).padding(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Estadísticas de la Sesión", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Cartas Jugadas", style = MaterialTheme.typography.labelMedium)
                        Text("${state.totalTurnsPlayed}", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.secondary)
                    }
                    if (state.durationSeconds > 0) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Tiempo Juntos", style = MaterialTheme.typography.labelMedium)
                            Text(formatDuration(state.durationSeconds), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.secondary)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onPlayAgain,
            shape = ExpressiveButtonShape,
            modifier = Modifier.fillMaxWidth(0.85f).height(56.dp)
        ) {
            Text("Jugar de Nuevo")
        }
    }

    if (showConsequenceDialog) {
        AlertDialog(
            onDismissRequest = { showConsequenceDialog = false },
            shape = RoundedCornerShape(24.dp),
            title = {
                Text(
                    text = state.consequenceTitle,
                    style = MaterialTheme.typography.titleLarge,
                    color = if (state.isReward) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                )
            },
            text = {
                Text(
                    text = if (state.consequenceDescription.isNotBlank()) state.consequenceDescription else "Disfruta o cumple tu consecuencia juntos.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            confirmButton = {
                Button(onClick = { showConsequenceDialog = false }, shape = ExpressiveButtonShape) {
                    Text("¡Entendido!")
                }
            }
        )
    }
}

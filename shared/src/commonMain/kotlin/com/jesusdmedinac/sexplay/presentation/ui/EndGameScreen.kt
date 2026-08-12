package com.jesusdmedinac.sexplay.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jesusdmedinac.sexplay.domain.model.state.GameState

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
                text = "🎉 ¡Completaron el juego juntos! 🎉",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Resistencia compartida. Ambos ganan un premio.", style = MaterialTheme.typography.bodyLarge)
        } else {
            Text("${state.loserName} no aguantó más.", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "🏆 ¡${state.winnerName} Gana! 🏆",
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
            Button(onClick = { onSelectConsequence(true) }) {
                Text("Recibir Premio")
            }
            if (!state.isSharedVictory) {
                Button(
                    onClick = { onSelectConsequence(false) },
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
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (state.isReward) "Premio para ${state.winnerName}" else "Castigo para ${state.loserName}",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(0.85f).height(200.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (state.isReward) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.consequenceTitle,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Session Statistics Display
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth(0.85f).padding(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("📊 Estadísticas de la Sesión", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
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
            modifier = Modifier.fillMaxWidth(0.85f).height(56.dp)
        ) {
            Text("Jugar de Nuevo")
        }
    }
}

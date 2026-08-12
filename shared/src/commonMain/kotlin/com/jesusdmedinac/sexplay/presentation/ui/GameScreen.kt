package com.jesusdmedinac.sexplay.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jesusdmedinac.sexplay.domain.model.state.GameState
import com.jesusdmedinac.sexplay.presentation.ui.components.FlipCardContainer
import com.jesusdmedinac.sexplay.presentation.ui.components.TensionProgressBar

@Composable
fun GameScreen(
    state: GameState.Playing,
    onNextTurn: () -> Unit,
    onSurrender: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Bar: Safe Word Indicator & Tension Progress Bar
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(
                color = MaterialTheme.colorScheme.errorContainer,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🛡️ Palabra de Seguridad: ",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                    Text(
                        text = state.safeWord,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            TensionProgressBar(
                turnCount = state.turnCount,
                maxCards = state.gameMode.maxCards
            )
        }

        // Active Player & Animated Card
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f).padding(vertical = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Turno de:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f)
            )
            Text(
                text = state.activePlayerName,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            FlipCardContainer(
                cardText = state.currentCard.text,
                onCardClick = onNextTurn
            )
        }

        // Action Buttons
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = onNextTurn,
                modifier = Modifier.fillMaxWidth(0.85f).height(56.dp)
            ) {
                Text("Siguiente Turno ➔")
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = onSurrender,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error),
                modifier = Modifier.fillMaxWidth(0.85f).height(56.dp)
            ) {
                Text("¡Me rindo! (No aguanto más)")
            }
        }
    }
}

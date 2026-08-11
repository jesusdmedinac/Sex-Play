package com.jesusdmedinac.sexplay.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TensionProgressBar(
    turnCount: Int,
    modifier: Modifier = Modifier
) {
    val maxEstimatedTurns = 20
    val progress = (turnCount.toFloat() / maxEstimatedTurns.toFloat()).coerceAtMost(1.0f)

    val barColor by animateColorAsState(
        targetValue = when {
            turnCount < 5 -> MaterialTheme.colorScheme.secondary
            turnCount < 12 -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.error
        }
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "🔥 Nivel de Tensión",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
            )
            Text(
                text = "Carta #$turnCount",
                style = MaterialTheme.typography.labelLarge,
                color = barColor
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth().height(8.dp),
            color = barColor,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

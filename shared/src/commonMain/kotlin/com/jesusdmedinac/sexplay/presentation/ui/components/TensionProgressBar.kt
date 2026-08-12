package com.jesusdmedinac.sexplay.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
    maxCards: Int = 20,
    modifier: Modifier = Modifier
) {
    val isMarathon = maxCards == Int.MAX_VALUE

    if (isMarathon) {
        // Marathon Mode: No linear progress bar, dynamic status badge instead
        val (statusText, statusColor) = when {
            turnCount <= 4 -> "Tensión: Suave" to MaterialTheme.colorScheme.secondary
            turnCount <= 9 -> "Tensión: En Aumento" to Color(0xFFFFB300)
            turnCount <= 15 -> "Tensión: Alta Tensión" to MaterialTheme.colorScheme.primary
            else -> "Tensión: Al Límite (Zona Crítica)" to MaterialTheme.colorScheme.error
        }

        val animatedColor by animateColorAsState(targetValue = statusColor)

        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = RoundedCornerShape(12.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.titleSmall,
                    color = animatedColor
                )
                Surface(
                    color = animatedColor.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Carta #$turnCount",
                        style = MaterialTheme.typography.labelLarge,
                        color = animatedColor,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }
        }
    } else {
        // Express & Standard Modes: Fixed duration with linear progress bar
        val progress = (turnCount.toFloat() / maxCards.toFloat()).coerceAtMost(1.0f)

        val barColor by animateColorAsState(
            targetValue = when {
                progress < 0.35f -> MaterialTheme.colorScheme.secondary
                progress < 0.70f -> MaterialTheme.colorScheme.primary
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
                    text = "Nivel de Tensión",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
                Text(
                    text = "Carta #$turnCount de $maxCards",
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
}

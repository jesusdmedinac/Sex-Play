package com.jesusdmedinac.sexplay.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DeepPlumBackground = Color(0xFF16081A)
val RichWineSurface = Color(0xFF25102A)
val BurgundySurfaceVariant = Color(0xFF39193F)
val NeonPinkPrimary = Color(0xFFEC407A)
val RoseGoldSecondary = Color(0xFFFFB74D)
val GlowingCrimsonError = Color(0xFFFF1744)

private val SensualDarkColorScheme = darkColorScheme(
    primary = NeonPinkPrimary,
    onPrimary = Color.White,
    primaryContainer = BurgundySurfaceVariant,
    onPrimaryContainer = Color.White,
    secondary = RoseGoldSecondary,
    onSecondary = Color.Black,
    background = DeepPlumBackground,
    onBackground = Color(0xFFF3E5F5),
    surface = RichWineSurface,
    onSurface = Color(0xFFF3E5F5),
    surfaceVariant = BurgundySurfaceVariant,
    onSurfaceVariant = Color(0xFFE1BEE7),
    error = GlowingCrimsonError,
    onError = Color.White,
    errorContainer = Color(0xFF4A0E17),
    onErrorContainer = Color(0xFFFFCDD2)
)

@Composable
fun SexPlayTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SensualDarkColorScheme,
        content = content
    )
}

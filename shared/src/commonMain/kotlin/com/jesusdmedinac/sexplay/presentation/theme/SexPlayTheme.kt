package com.jesusdmedinac.sexplay.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DeepPlumBackground = Color(0xFF16081A)
val RichWineSurface = Color(0xFF25102A)
val BurgundySurfaceVariant = Color(0xFF39193F)
val NeonPinkPrimary = Color(0xFFEC407A)
val DarkOnPrimary = Color(0xFF18040C) // Optimized for WCAG 2.1 AA (Contrast 5.27:1)
val RoseGoldSecondary = Color(0xFFFFB74D)
val HighLuminanceCrimson = Color(0xFFFF8099) // Optimized for WCAG 2.1 AAA (Contrast 7.41:1)
val DarkErrorContainer = Color(0xFF2D080D)

private val SensualDarkColorScheme = darkColorScheme(
    primary = NeonPinkPrimary,
    onPrimary = DarkOnPrimary,
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
    error = HighLuminanceCrimson,
    onError = Color.White,
    errorContainer = DarkErrorContainer,
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

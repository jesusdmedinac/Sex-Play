package com.jesusdmedinac.sexplay.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val DeepPlumBackground = Color(0xFF16081A)
val RichWineSurface = Color(0xFF25102A)
val BurgundySurfaceVariant = Color(0xFF39193F)
val NeonPinkPrimary = Color(0xFFEC407A)
val DarkOnPrimary = Color(0xFF18040C) // Optimized for WCAG 2.1 AA (Contrast 5.27:1)
val RoseGoldSecondary = Color(0xFFFFB74D)
val HighLuminanceCrimson = Color(0xFFFF8099) // Optimized for WCAG 2.1 AAA (Contrast 7.41:1)
val DarkErrorContainer = Color(0xFF2D080D)
val DefaultTextColor = Color(0xFFF3E5F5)

// M3 Expressive Tonal Surface Containers
val SurfaceContainerLowest = Color(0xFF110414)
val SurfaceContainerLow = Color(0xFF1B0A20)
val SurfaceContainer = Color(0xFF25102A)
val SurfaceContainerHigh = Color(0xFF33163B)
val SurfaceContainerHighest = Color(0xFF421C4D)

// M3 Expressive Asymmetric Shapes
val ExpressiveAsymmetricCardShape = RoundedCornerShape(
    topStart = 32.dp,
    topEnd = 12.dp,
    bottomEnd = 32.dp,
    bottomStart = 12.dp
)

val ExpressiveButtonShape = RoundedCornerShape(24.dp)

private val SensualDarkColorScheme = darkColorScheme(
    primary = NeonPinkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = BurgundySurfaceVariant,
    onPrimaryContainer = Color.White,
    secondary = RoseGoldSecondary,
    onSecondary = Color.Black,
    background = DeepPlumBackground,
    onBackground = DefaultTextColor,
    surface = RichWineSurface,
    onSurface = DefaultTextColor,
    surfaceVariant = BurgundySurfaceVariant,
    onSurfaceVariant = Color(0xFFE1BEE7),
    surfaceContainerLowest = SurfaceContainerLowest,
    surfaceContainerLow = SurfaceContainerLow,
    surfaceContainer = SurfaceContainer,
    surfaceContainerHigh = SurfaceContainerHigh,
    surfaceContainerHighest = SurfaceContainerHighest,
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
        colorScheme = SensualDarkColorScheme
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onBackground,
            content = content
        )
    }
}

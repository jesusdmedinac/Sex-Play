package com.jesusdmedinac.sexplay.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Eros & Ember - Sensual Dark Palette
val DeepPlumBackground = Color(0xFF16081A)
val RichWineSurface = Color(0xFF25102A)
val BurgundySurfaceVariant = Color(0xFF402F43)
val NeonPinkPrimary = Color(0xFFEC407A)
val DarkOnPrimary = Color(0xFF18040C) // Optimized for WCAG 2.1 AA (Contrast 5.27:1)
val RoseGoldSecondary = Color(0xFFFFB74D)
val EmeraldTertiary = Color(0xFF63DF73)
val DarkOnTertiary = Color(0xFF00390F)
val EmeraldTertiaryContainer = Color(0xFF21A643)
val DarkOnTertiaryContainer = Color(0xFF00320C)
val HighLuminanceCrimson = Color(0xFFFF8099) // Optimized for WCAG 2.1 AAA (Contrast 7.41:1)
val DarkErrorContainer = Color(0xFF2D080D) // Ultra-dark crimson container for >7.0:1 AAA contrast
val DefaultTextColor = Color(0xFFF4DBF5)
val DefaultTextColorVariant = Color(0xFFE1BEC4)

// M3 Expressive Tonal Surface Containers (Eros & Ember Specs)
val SurfaceContainerLowest = Color(0xFF17091B)
val SurfaceContainerLow = Color(0xFF251629)
val SurfaceContainer = Color(0xFF25102A)
val SurfaceContainerHigh = Color(0xFF342438)
val SurfaceContainerHighest = Color(0xFF402F43)

// Container border color
val SurfaceContainerBorderColor = Color(0x1AFFB1C2)

// M3 Expressive Asymmetric Shapes (32dp / 12dp alternation)
val ExpressiveAsymmetricCardShape = RoundedCornerShape(
    topStart = 32.dp,
    topEnd = 12.dp,
    bottomEnd = 32.dp,
    bottomStart = 12.dp
)

val ExpressiveButtonShape = RoundedCornerShape(24.dp)
val ExpressivePillShape = RoundedCornerShape(9999.dp)

// Material 3 Expressive Shapes Scale
val ExpressiveShapes = Shapes(
    extraSmall = RoundedCornerShape(12.dp),
    small = RoundedCornerShape(20.dp),
    medium = ExpressiveAsymmetricCardShape,
    large = ExpressiveAsymmetricCardShape,
    extraLarge = ExpressiveButtonShape,

)

// Eros & Ember Typography Hierarchy (Sora / Inter / Space Grotesk)
val ExpressiveTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 48.sp,
        lineHeight = 56.sp,
        letterSpacing = (-0.02).sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 40.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.05.sp
    )
)

private val SensualDarkColorScheme = darkColorScheme(
    primary = NeonPinkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = Color(0xFFFD4E87),
    onPrimaryContainer = Color(0xFF590025),
    secondary = RoseGoldSecondary,
    onSecondary = Color(0xFF452B00),
    secondaryContainer = Color(0xFFC3841B),
    onSecondaryContainer = Color(0xFF3C2500),
    tertiary = EmeraldTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = EmeraldTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    background = DeepPlumBackground,
    onBackground = DefaultTextColor,
    surface = RichWineSurface,
    onSurface = DefaultTextColor,
    surfaceVariant = BurgundySurfaceVariant,
    onSurfaceVariant = DefaultTextColorVariant,
    surfaceContainerLowest = SurfaceContainerLowest,
    surfaceContainerLow = SurfaceContainerLow,
    surfaceContainer = SurfaceContainer,
    surfaceContainerHigh = SurfaceContainerHigh,
    surfaceContainerHighest = SurfaceContainerHighest,
    error = HighLuminanceCrimson,
    onError = Color(0xFF690005),
    errorContainer = DarkErrorContainer,
    onErrorContainer = Color(0xFFFFDAD6)
)

@Composable
fun SexPlayTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SensualDarkColorScheme,
        typography = ExpressiveTypography,
        shapes = ExpressiveShapes
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onBackground,
            content = content
        )
    }
}

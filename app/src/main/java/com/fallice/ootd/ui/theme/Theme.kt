package com.fallice.ootd.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = PrimaryForeground,
    secondary = Accent,
    onSecondary = AccentForeground,
    background = Color(0xFF1A1510),
    onBackground = Color(0xFFFAF8F5),
    surface = Color(0xFF252018),
    onSurface = Color(0xFFFAF8F5),
    surfaceVariant = Color(0xFF3A3328),
    onSurfaceVariant = Color(0xFFD4C8B8),
    error = Error,
    onError = Color(0xFFFFFFFF),
    outline = Color(0xFF5D5245),
    outlineVariant = Color(0xFF4D4235),
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = PrimaryForeground,
    secondary = Accent,
    onSecondary = AccentForeground,
    background = Background,
    onBackground = TextPrimary,
    surface = Surface,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = TextSecondary,
    error = Error,
    onError = Color(0xFFFFFFFF),
    outline = Border,
    outlineVariant = BorderLight,
)

@Composable
fun OotdTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

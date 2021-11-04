package com.aqube.notes.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = White,
    onPrimary = Black,
    primaryVariant = PaleWhite,
    surface = Yellow600,
    secondary = Yellow600,
)

private val DarkColorPalette = darkColors(
    primary = Black,
    onPrimary = White,
    primaryVariant = PaleBlack,
    surface = Yellow600,
    secondary = Yellow600
)

@Composable
fun NoteAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = QuickSandTypography,
        shapes = Shapes,
        content = content
    )
}
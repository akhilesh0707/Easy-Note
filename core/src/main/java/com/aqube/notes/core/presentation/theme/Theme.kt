package com.aqube.notes.core.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/*private val DarkColorPalette = darkColors(
    primary = Color.White,
    background = DarkGray,
    onBackground = Color.White,
    surface = LightBlue,
    onSurface = DarkGray
)*/

private val LightColorPalette = lightColors(
    primary = Yellow600,
    primaryVariant = Color.Black,
    onPrimary = Color.White,
    secondary = Color.White,
    secondaryVariant = Yellow300,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Gray,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = BlackDark,
)

private val DarkColorPalette = darkColors(
    primary = Yellow800,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    secondary = BlackDark,
    onSecondary = Color.White,
    error = RedErrorLight,
    background = Color.Black,
    onBackground = BlackDark,
    surface = BlackLight,
    onSurface = BlackDark,
)


@Composable
fun NoteAppTheme(darkTheme: Boolean = false, content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = QuickSandTypography,
        shapes = Shapes,
        content = content
    )
}
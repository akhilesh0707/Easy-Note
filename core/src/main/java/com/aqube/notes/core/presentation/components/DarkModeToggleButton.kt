package com.aqube.notes.core.presentation.components

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.R

@Composable
fun DarkModeToggleButton(
    darkMode: Boolean,
    onDarkModeChanged: (Boolean) -> Unit,
    modifier: Modifier
) {
    IconButton(onClick = { onDarkModeChanged(!darkMode) }) {
        val color by animateColorAsState(targetValue = MaterialTheme.colors.onSurface)
        val iconModifier = Modifier.size(24.dp)
        val value = when (darkMode) {
            true -> Icon(
                Icons.Default.LightMode,
                stringResource(R.string.label_light_mode),
                iconModifier,
                color
            )
            else -> Icon(
                Icons.Default.DarkMode,
                stringResource(R.string.label_dark_mode),
                iconModifier,
                color
            )
        }
    }
}

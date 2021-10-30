package com.aqube.notes.feature_settings.presentation.components.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aqube.notes.core.presentation.components.DarkModeToggleButton

@Composable
fun DarkThemeRow(
    label: String,
    darkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onPrimary
        )
        DarkModeToggleButton(
            darkMode = darkTheme,
            onDarkModeChanged = { toggleValue ->
                onToggleTheme(toggleValue)
            }
        )
    }
}
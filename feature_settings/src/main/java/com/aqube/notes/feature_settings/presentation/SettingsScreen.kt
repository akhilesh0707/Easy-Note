package com.aqube.notes.feature_settings.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aqube.notes.core.presentation.components.DarkModeToggleButton

@Composable
fun SettingsScreen(
    darkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit,
    upPress: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Dark theme",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary
            )
            DarkModeToggleButton(
                darkMode = darkTheme,
                onDarkModeChanged = { toggleValue ->
                    onToggleTheme(toggleValue)
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    SettingsScreen(darkTheme = true,onToggleTheme = { },{})
}

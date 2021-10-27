package com.aqube.notes.feature_settings.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aqube.notes.core.domain.model.AppTheme
import com.aqube.notes.core.presentation.components.DarkModeToggleButton

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel(),
    darkTheme: Boolean,
    onToggleTheme: (AppTheme) -> Unit
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
                color = MaterialTheme.colors.primaryVariant
            )
            DarkModeToggleButton(
                darkMode = darkTheme,
                onDarkModeChanged = { toggleValue ->
                    val isDarkTheme = if (toggleValue) AppTheme.MODE_NIGHT else AppTheme.MODE_DAY
                    onToggleTheme(isDarkTheme)
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}
package com.aqube.notes.feature_settings.presentation.components.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.R
import com.aqube.notes.feature_settings.presentation.components.SettingsItem

@Composable
fun ThemeItem(
    label: String,
    isChecked: Boolean,
    onToggledChanged: (Boolean) -> Unit,
) {
    SettingsItem(label = label,
        icon = painterResource(R.drawable.ic_theme),
        content = { ThemeSwitch(isChecked = isChecked, onToggledChanged = onToggledChanged) }
    ) {}
}

@Composable
fun ThemeSwitch(
    isChecked: Boolean,
    onToggledChanged: (Boolean) -> Unit
) {
    Switch(
        modifier = Modifier.padding(end = 8.dp),
        checked = isChecked,
        onCheckedChange = onToggledChanged
    )
}
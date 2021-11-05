package com.aqube.notes.feature_settings.presentation.components.version

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.R
import com.aqube.notes.feature_settings.presentation.components.SettingsItem

@Composable
fun VersionItem(
    label: String,
    appVersion: String
) {
    SettingsItem(
        label = label,
        icon = painterResource(R.drawable.ic_phone),
        content = {
            AppVersionNumber(appVersion = appVersion)
        }
    ) {}
}

@Composable
fun AppVersionNumber(appVersion: String) {
    Text(
        modifier = Modifier.padding(start = 8.dp, end = 16.dp),
        text = appVersion,
        style = MaterialTheme.typography.h5,
        color = Color.Gray
    )
}
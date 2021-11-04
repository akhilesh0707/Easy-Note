package com.aqube.notes.feature_settings.presentation

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.R
import com.aqube.notes.core.presentation.theme.NoteAppTheme
import com.aqube.notes.feature_settings.presentation.components.SettingsItem
import com.aqube.notes.feature_settings.presentation.components.SettingsSection
import com.aqube.notes.feature_settings.presentation.components.theme.ThemeItem
import com.aqube.notes.feature_settings.presentation.components.version.VersionItem

@Composable
fun SettingsScreen(
    darkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit,
    upPress: () -> Unit,
    context: Context = LocalContext.current
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item { SettingsSection(title = "Settings") }
        item {
            ThemeItem(
                label = "Dark theme",
                isChecked = darkTheme,
                onToggledChanged = onToggleTheme
            )
        }
        /*  item { VersionRow(label = "Application version", context.getVersionName()) }*/
        item { VersionItem(label = "App version", "1.2.0") }
        item { SettingsSection(title = "Profiles") }
        item { SettingsItem("LinkedIn", painterResource(R.drawable.ic_linkedin), {}, {}) }
        item { SettingsItem("Stackoverflow", painterResource(R.drawable.ic_stackoverflow), {}, {}) }
        item { SettingsItem("Github", painterResource(R.drawable.ic_github), {}, {}) }
    }
}

@Preview(name = "Preview", group = "Size")
@Composable
fun SettingsPreview() {
    NoteAppTheme() {
        SettingsScreen(darkTheme = false, onToggleTheme = { }, {}, LocalContext.current)
    }
}
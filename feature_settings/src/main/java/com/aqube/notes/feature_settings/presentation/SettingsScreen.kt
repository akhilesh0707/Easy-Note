package com.aqube.notes.feature_settings.presentation

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.presentation.components.LabelView
import com.aqube.notes.core.presentation.theme.NoteAppTheme
import com.aqube.notes.core.util.getVersionName
import com.aqube.notes.feature_settings.presentation.components.theme.DarkThemeRow
import com.aqube.notes.feature_settings.presentation.components.version.VersionRow

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
            .padding(16.dp),

        ) {
        item { LabelView(title = "Settings") }
        item {
            DarkThemeRow(
                label = "Dark theme",
                darkTheme = darkTheme,
                onToggleTheme = onToggleTheme
            )
        }
        item { VersionRow(label = "Application version", context.getVersionName()) }
    }

}

@Preview(name = "Preview", group = "Size")
@Composable
fun SettingsPreview() {
    NoteAppTheme() {
        SettingsScreen(darkTheme = false, onToggleTheme = { }, {}, LocalContext.current)
    }
}
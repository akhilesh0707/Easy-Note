package com.aqube.notes.feature_settings.presentation

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.R
import com.aqube.notes.core.presentation.components.AppBar
import com.aqube.notes.core.util.getVersionName
import com.aqube.notes.core.util.openWebPage
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
    Scaffold(
        topBar = { AppBar { upPress() } }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            item { SettingsSection(title = stringResource(id = R.string.settings)) }
            item {
                ThemeItem(
                    label = stringResource(id = R.string.label_dark_mode),
                    isChecked = darkTheme,
                    onToggledChanged = onToggleTheme
                )
            }
            item {
                val label = stringResource(id = R.string.label_app_version)
                VersionItem(label = label, appVersion = context.getVersionName())
            }
            item { SettingsSection(title = stringResource(id = R.string.label_profiles)) }
            item {
                val label = stringResource(id = R.string.label_linkedin)
                val icon = painterResource(R.drawable.ic_linkedin)
                val url = stringResource(id = R.string.label_linkedin_profile)
                SettingsItem(label = label, icon = icon, {}) {
                    context.openWebPage(url)
                }
            }
            item {
                val label = stringResource(id = R.string.label_stackoverflow)
                val icon = painterResource(R.drawable.ic_stackoverflow)
                val url = stringResource(id = R.string.label_stackoverflow_profile)
                SettingsItem(label = label, icon = icon, {}) {
                    context.openWebPage(url)
                }
            }
            item {
                val label = stringResource(id = R.string.label_github)
                val icon = painterResource(id = R.drawable.ic_github)
                val url = stringResource(id = R.string.label_github_profile)
                SettingsItem(label = label, icon = icon, content = {}) {
                    context.openWebPage(url)
                }
            }
        }
    }
}

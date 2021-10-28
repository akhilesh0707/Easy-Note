package com.aqube.notes.core.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.aqube.notes.core.data.data_source.PreferenceDataStore
import com.aqube.notes.core.domain.repository.ThemeSettings
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemeSettingsImpl @Inject constructor(
    @ApplicationContext context: Context
) : PreferenceDataStore(context = context, PREF_FILE_UI_THEME), ThemeSettings {

    companion object {
        private const val PREF_FILE_UI_THEME = "ui_theme_preference"
        private val UI_THEME_KEY = booleanPreferencesKey("ui_theme")
    }

    override val uiTheme: Flow<Boolean>
        get() = dataStore.data.map { pref ->
            val uiTheme = pref[UI_THEME_KEY] ?: false
            uiTheme
        }

    override suspend fun saveToDataStore(isNightMode: Boolean) {
        dataStore.edit { mutablePref ->
            mutablePref[UI_THEME_KEY] = isNightMode
        }
    }
}
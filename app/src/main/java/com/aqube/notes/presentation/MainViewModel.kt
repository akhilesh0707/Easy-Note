package com.aqube.notes.presentation

import androidx.lifecycle.ViewModel
import com.aqube.notes.core.domain.model.AppTheme
import com.aqube.notes.core.domain.repository.ThemeSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val themeSettings: ThemeSettings
) : ViewModel() {

    fun getThemeState(): StateFlow<AppTheme> = themeSettings.themeStream

    fun updateTheme(theme: AppTheme) {
        themeSettings.theme = theme
    }

}
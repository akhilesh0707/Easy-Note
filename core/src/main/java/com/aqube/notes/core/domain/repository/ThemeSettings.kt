package com.aqube.notes.core.domain.repository

import com.aqube.notes.core.domain.model.AppTheme
import kotlinx.coroutines.flow.StateFlow

interface ThemeSettings {
    val themeStream: StateFlow<AppTheme>
    var theme: AppTheme
}
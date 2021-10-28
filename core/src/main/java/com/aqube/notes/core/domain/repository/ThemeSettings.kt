package com.aqube.notes.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface ThemeSettings {
    val uiTheme: Flow<Boolean>
    suspend fun saveToDataStore(isNightMode: Boolean)
}
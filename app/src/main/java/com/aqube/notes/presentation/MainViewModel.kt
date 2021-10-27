package com.aqube.notes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqube.notes.core.domain.repository.ThemeSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val themeSettings: ThemeSettings
) : ViewModel() {

    fun getTheme() = themeSettings.uiTheme

    fun updateTheme(theme: Boolean) {
        viewModelScope.launch {
            themeSettings.saveToDataStore(theme)
        }
    }

}
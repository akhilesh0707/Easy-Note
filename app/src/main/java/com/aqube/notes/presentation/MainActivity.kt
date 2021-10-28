package com.aqube.notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.lifecycleScope
import com.aqube.notes.core.presentation.theme.NoteAppTheme
import com.aqube.notes.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteMain()
        }
        observeUITheme()
    }

    @Composable
    fun NoteMain() {
        // Check Theme
        val isDarkTheme by viewModel.getTheme().collectAsState(initial = isSystemInDarkTheme())

        // Set theme
        val toggleTheme: (Boolean) -> Unit = { appTheme ->
            viewModel.updateTheme(appTheme)
        }

        NoteAppTheme(darkTheme = isDarkTheme){
            Surface(color = MaterialTheme.colors.background) {
                NavigationGraph(isDarkTheme,toggleTheme)
            }
        }
    }

    private fun observeUITheme() {
        lifecycleScope.launchWhenStarted {
            viewModel.getTheme().collect {
                val isDarkMode = when (it) {
                    true -> AppCompatDelegate.MODE_NIGHT_YES
                    false -> AppCompatDelegate.MODE_NIGHT_NO
                }
                AppCompatDelegate.setDefaultNightMode(isDarkMode)
            }
        }
    }

}
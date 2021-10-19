package com.aqube.notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aqube.notes.core.domain.model.AppTheme
import com.aqube.notes.core.presentation.theme.NoteAppTheme
import com.aqube.notes.feature_note.presentation.add_edit_notes.components.AddEditNoteScreen
import com.aqube.notes.feature_note.presentation.notes.NotesScreen
import com.aqube.notes.feature_note.presentation.util.Screen
import com.aqube.notes.feature_settings.presentation.SettingsScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = getSavedTheme()
            NoteAppTheme(darkTheme = isDarkTheme) {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ) {
                        composable(route = Screen.NotesScreen.route) {
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(name = "noteId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "noteColor") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(navController = navController, noteColor = color)
                        }
                        composable(route = Screen.SettingsScreen.route) {
                            SettingsScreen(
                                darkTheme = isDarkTheme,
                                navController = navController,
                                onToggleTheme = { appTheme ->
                                    viewModel.updateTheme(appTheme)
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun getSavedTheme(): Boolean {
        val savedTheme = viewModel.getThemeState().collectAsState()
        val isDarkTheme = when (savedTheme.value) {
            AppTheme.MODE_AUTO -> isSystemInDarkTheme()
            AppTheme.MODE_DAY -> false
            AppTheme.MODE_NIGHT -> true
        }
        return isDarkTheme
    }

}
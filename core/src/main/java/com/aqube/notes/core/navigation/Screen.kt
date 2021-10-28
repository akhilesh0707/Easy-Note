package com.aqube.notes.core.navigation

sealed class Screen(val route: String) {
    object NotesScreen : Screen("note_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")
    object SettingsScreen : Screen("settings_screen")
}

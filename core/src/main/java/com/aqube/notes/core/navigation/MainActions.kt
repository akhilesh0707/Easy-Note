package com.aqube.notes.core.navigation

import androidx.navigation.NavHostController

class MainActions(navController: NavHostController) {
    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val gotoNoteAddEditNote: (Int, Int) -> Unit = { noteId, noteColor ->
        navController.navigate("${Screen.AddEditNoteScreen.route}/$noteId/$noteColor")
    }

    val gotoSettings: () -> Unit = {
        navController.navigate(Screen.SettingsScreen.route)
    }
}

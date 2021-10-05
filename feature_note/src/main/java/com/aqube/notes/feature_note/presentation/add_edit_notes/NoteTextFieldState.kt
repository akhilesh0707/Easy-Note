package com.aqube.notes.feature_note.presentation.add_edit_notes

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val hintVisible: Boolean = true
)
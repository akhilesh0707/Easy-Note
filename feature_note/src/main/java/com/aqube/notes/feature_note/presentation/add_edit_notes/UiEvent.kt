package com.aqube.notes.feature_note.presentation.add_edit_notes

sealed class UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent()
    object SaveNote : UiEvent()
}

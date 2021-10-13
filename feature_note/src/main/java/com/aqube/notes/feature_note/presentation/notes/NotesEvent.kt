package com.aqube.notes.feature_note.presentation.notes

import androidx.compose.ui.focus.FocusState
import com.aqube.notes.feature_note.domain.model.Note
import com.aqube.notes.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class EnteredSearch(val value: String) : NotesEvent()
    data class SearchNotes(val value: String) : NotesEvent()
    data class ChangeSearchFocus(val focusState: FocusState) : NotesEvent()
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSelection : NotesEvent()
}

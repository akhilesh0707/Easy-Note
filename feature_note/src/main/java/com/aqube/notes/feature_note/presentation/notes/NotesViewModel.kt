package com.aqube.notes.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqube.notes.feature_note.domain.model.Note
import com.aqube.notes.feature_note.domain.use_case.NoteUseCases
import com.aqube.notes.feature_note.domain.util.NoteOrder
import com.aqube.notes.feature_note.domain.util.OrderType
import com.aqube.notes.feature_note.presentation.add_edit_notes.NoteTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {
    private val _states = mutableStateOf(NotesState())
    val state: State<NotesState> = _states

    private val _noteSearch = mutableStateOf(NoteTextFieldState(hint = "Search Notes"))
    val search: State<NoteTextFieldState> = _noteSearch

    private var recentlyDeletedNote: Note? = null
    private var getNoteJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSelection -> {
                _states.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
            is NotesEvent.SearchNotes -> {
                if (event.value.isNullOrEmpty()) {
                    getNotes(NoteOrder.Date(OrderType.Descending))
                    _noteSearch.value = search.value.copy(
                        text = event.value
                    )
                } else {
                    _noteSearch.value = search.value.copy(
                        text = event.value
                    )
                    getNotes(NoteOrder.Date(OrderType.Descending), event.value)
                }
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder, query: String = "") {
        getNoteJob?.cancel()
        getNoteJob = noteUseCases.getNotes(noteOrder, query).onEach { notes ->
            _states.value = state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}
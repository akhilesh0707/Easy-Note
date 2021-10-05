package com.aqube.notes.feature_note.presentation.add_edit_notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqube.notes.feature_note.domain.model.InvalidNoteException
import com.aqube.notes.feature_note.domain.model.Note
import com.aqube.notes.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {
    private val _noteTitle = mutableStateOf(NoteTextFieldState(hint = "Note title"))
    val title: State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState(hint = "Note content"))
    val content: State<NoteTextFieldState> = _noteContent

    private val _noteColor = mutableStateOf<Int>(Note.noteColors.random().toArgb())
    val color: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val currentNoteId: Int? = null

    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitle.value = title.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value = title.value.copy(
                    isHintVisible = !event.focusState.isFocused && title.value.text.isBlank()
                )
            }

            is AddEditNoteEvent.EnteredContent -> {
                _noteContent.value = content.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContent.value = content.value.copy(
                    isHintVisible = !event.focusState.isFocused && content.value.text.isBlank()
                )
            }

            is AddEditNoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }

            AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNote(
                            Note(
                                id = currentNoteId,
                                title = title.value.text,
                                content = content.value.text,
                                timeStamp = System.currentTimeMillis(),
                                color = color.value
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e: InvalidNoteException) {
                        _eventFlow.emit(UiEvent.ShowSnackBar(e.message ?: "Unknown error"))
                    }
                }
            }
        }
    }
}
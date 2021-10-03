package com.aqube.notes.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import com.aqube.notes.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(notes: NoteUseCases) : ViewModel() {

}
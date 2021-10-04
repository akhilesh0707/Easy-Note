package com.aqube.notes.feature_note.domain.use_case

data class NoteUseCases(
    val addNote: AddNote,
    val getNote: GetNote,
    val deleteNote: DeleteNote
)
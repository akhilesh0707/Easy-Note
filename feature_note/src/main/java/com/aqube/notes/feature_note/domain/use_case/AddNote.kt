package com.aqube.notes.feature_note.domain.use_case

import com.aqube.notes.feature_note.domain.model.InvalidNoteException
import com.aqube.notes.feature_note.domain.model.Note
import com.aqube.notes.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Please add title for note")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Please add content for note")
        }
        repository.insertNote(note)
    }
}
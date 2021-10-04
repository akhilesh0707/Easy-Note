package com.aqube.notes.di

import com.aqube.notes.feature_note.data.data_source.NoteDatabase
import com.aqube.notes.feature_note.data.repository.NoteRepositoryImpl
import com.aqube.notes.feature_note.domain.repository.NoteRepository
import com.aqube.notes.feature_note.domain.use_case.AddNote
import com.aqube.notes.feature_note.domain.use_case.DeleteNote
import com.aqube.notes.feature_note.domain.use_case.GetNote
import com.aqube.notes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(noteDatabase.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            AddNote(noteRepository),
            GetNote(noteRepository),
            DeleteNote(noteRepository)
        )
    }
}
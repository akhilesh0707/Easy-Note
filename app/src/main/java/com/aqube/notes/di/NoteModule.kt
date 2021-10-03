package com.aqube.notes.di

import com.aqube.notes.feature_note.data.data_source.NoteDatabase
import com.aqube.notes.feature_note.data.repository.NoteRepositoryImpl
import com.aqube.notes.feature_note.domain.repository.NoteRepository
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
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(noteDatabase.noteDao)
    }

}
package com.aqube.notes.di

import com.aqube.notes.core.data.repository.ThemeSettingsImpl
import com.aqube.notes.core.domain.repository.ThemeSettings
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {
    @Binds
    @Singleton
    abstract fun bindUserSettings(userSettingsImpl: ThemeSettingsImpl): ThemeSettings
}
package com.aqube.notes.core.domain.model

enum class AppTheme {
    MODE_DAY,
    MODE_NIGHT,
    MODE_AUTO;

    companion object {
        fun fromOrdinal(ordinal: Int) = values()[ordinal]
    }
}
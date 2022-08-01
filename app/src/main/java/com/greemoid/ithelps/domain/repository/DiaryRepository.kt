package com.greemoid.ithelps.domain.repository

import com.greemoid.ithelps.domain.models.DiaryNote

interface DiaryRepository {

    fun allDiaryNotes(): List<DiaryNote>

    suspend fun upsertDiaryNote(diaryNote: DiaryNote)
}
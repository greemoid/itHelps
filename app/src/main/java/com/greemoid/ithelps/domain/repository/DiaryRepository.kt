package com.greemoid.ithelps.domain.repository

import com.greemoid.ithelps.domain.models.diary.DiaryNote

interface DiaryRepository {

    fun getAllDiaryNotes(): List<DiaryNote>

    suspend fun upsertDiaryNote(diaryNote: DiaryNote)
}
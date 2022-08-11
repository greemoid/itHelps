package com.greemoid.ithelps.domain.usecases.diary

import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.repository.DiaryRepository

class SaveDiaryNoteUseCase(
    private val diaryRepository: DiaryRepository,
) {
    suspend fun saveDiaryNote(diaryNote: DiaryNote): Boolean {
        diaryRepository.upsertDiaryNote(diaryNote)
        return true
    }
}
package com.greemoid.ithelps.domain.usecases.diary

import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.repository.DiaryRepository
import javax.inject.Inject

class GetAllDiaryNotesUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository,
) {

    fun getAllDiaryNotes(): List<DiaryNote> {
        return diaryRepository.getAllDiaryNotes()
    }
}
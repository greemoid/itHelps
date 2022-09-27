package com.greemoid.ithelps.domain.usecases.diary

import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.repository.DiaryRepository
import javax.inject.Inject

class GetLastDiaryNoteUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository,
) {
    suspend fun getLastNote(): DiaryNote = diaryRepository.getLastDiaryNote()

}
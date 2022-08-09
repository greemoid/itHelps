package com.greemoid.ithelps.domain.usecases.mood

import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.repository.MoodRepository

class SaveMoodUseCase(
    private val moodRepository: MoodRepository,
) {

    suspend fun saveMood(mood: Mood): Boolean {
        moodRepository.insertMood(mood)
        return true
    }
}
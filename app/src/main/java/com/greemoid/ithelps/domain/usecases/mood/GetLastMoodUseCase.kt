package com.greemoid.ithelps.domain.usecases.mood

import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.repository.MoodRepository

class GetLastMoodUseCase(
    private val moodRepository: MoodRepository,
) {
    suspend fun getLastMood(): Mood = moodRepository.getLastMood()

}
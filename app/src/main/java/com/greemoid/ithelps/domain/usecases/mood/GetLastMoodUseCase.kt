package com.greemoid.ithelps.domain.usecases.mood

import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.repository.MoodRepository
import javax.inject.Inject

class GetLastMoodUseCase @Inject constructor(
    private val moodRepository: MoodRepository,
) {
    suspend fun getLastMood(): Mood = moodRepository.getLastMood()

}
package com.greemoid.ithelps.domain.usecases.mood

import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.repository.MoodRepository

class GetAllMoodsUseCase(
    private val moodRepository: MoodRepository
) {

    suspend fun getAllMoods(): List<Mood> {
        return moodRepository.getAllMoods()
    }
}
package com.greemoid.ithelps.domain.usecases.meditation

import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.repository.MeditationRepository

class SaveMeditationSessionUseCase(
    private val meditationRepository: MeditationRepository
) {

    suspend fun saveMeditationSession(meditation: Meditation) {
        meditationRepository.insertMeditationTime(meditation)
    }
}
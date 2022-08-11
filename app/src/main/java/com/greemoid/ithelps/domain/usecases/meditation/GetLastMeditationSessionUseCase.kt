package com.greemoid.ithelps.domain.usecases.meditation

import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.repository.MeditationRepository

class GetLastMeditationSessionUseCase(
    private val meditationRepository: MeditationRepository,
) {

    suspend fun getLastMeditationSession(): Meditation {
        return meditationRepository.getLastMeditationSession()
    }
}
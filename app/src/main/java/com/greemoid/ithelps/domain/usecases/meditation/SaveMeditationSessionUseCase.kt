package com.greemoid.ithelps.domain.usecases.meditation

import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.repository.MeditationRepository
import javax.inject.Inject

class SaveMeditationSessionUseCase @Inject constructor(
    private val meditationRepository: MeditationRepository,
) {

    suspend fun saveMeditationSession(meditation: Meditation) {
        meditationRepository.insertMeditationTime(meditation)
    }
}
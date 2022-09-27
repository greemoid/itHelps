package com.greemoid.ithelps.domain.usecases.meditation

import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.repository.MeditationRepository
import javax.inject.Inject

class GetLastMeditationSessionUseCase @Inject constructor(
    private val meditationRepository: MeditationRepository,
) {

    suspend fun getLastMeditationSession(): Meditation {
        return meditationRepository.getLastMeditationSession()
    }
}
package com.greemoid.ithelps.domain.usecases.meditation

import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.repository.MeditationRepository
import javax.inject.Inject

class GetAllMeditationSessionsUseCase @Inject constructor(
    private val meditationRepository: MeditationRepository,
) {

    fun getAllMeditationSessions(): List<Meditation> {
        return meditationRepository.getAllMeditationSessions()
    }
}
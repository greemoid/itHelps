package com.greemoid.ithelps.domain.repository

import com.greemoid.ithelps.domain.models.meditation.Meditation

interface MeditationRepository {

    suspend fun insertMeditationTime(meditation: Meditation)

    fun getAllMeditationSessions(): List<Meditation>

    suspend fun getLastMeditationSession(): Meditation
}
package com.greemoid.ithelps.domain.repository

import com.greemoid.ithelps.domain.models.Mood

interface MoodRepository {

    fun getAllMoods() : List<Mood>

    suspend fun insertMood(mood: Mood)
}
package com.greemoid.ithelps.domain.repository

import com.greemoid.ithelps.domain.models.mood.Mood

interface MoodRepository {

    fun getAllMoods(): List<Mood>

    suspend fun insertMood(mood: Mood)
}
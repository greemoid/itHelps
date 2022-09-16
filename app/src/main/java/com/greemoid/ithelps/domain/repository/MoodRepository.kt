package com.greemoid.ithelps.domain.repository

import com.greemoid.ithelps.domain.models.mood.Mood

interface MoodRepository {

    suspend fun getAllMoods(): List<Mood>

    suspend fun getLastMood(): Mood

    suspend fun insertMood(mood: Mood)
}
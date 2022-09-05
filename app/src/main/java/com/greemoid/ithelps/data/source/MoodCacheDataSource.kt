package com.greemoid.ithelps.data.source

import com.greemoid.ithelps.data.db.MoodDao
import com.greemoid.ithelps.data.mapper.mood.MoodDBToMoodMapper
import com.greemoid.ithelps.data.mapper.mood.MoodToMoodDBMapper
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.repository.MoodRepository

class MoodCacheDataSource(
    private val moodDao: MoodDao,
    private val mapperToDomain: MoodDBToMoodMapper,
    private val mapperToData: MoodToMoodDBMapper,
) : MoodRepository {
    override suspend fun getAllMoods(): List<Mood> {
        val list = moodDao.getAllMoods()
        return mapperToDomain.map(list)
    }

    override suspend fun insertMood(mood: Mood) {
        moodDao.insertMood(mapperToData.map(mood))
    }
}
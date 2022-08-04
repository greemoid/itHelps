package com.greemoid.ithelps.data.source

import com.greemoid.ithelps.data.db.diaryDB.MoodDao
import com.greemoid.ithelps.data.mapper.MoodDBToMoodMapper
import com.greemoid.ithelps.data.mapper.MoodToMoodDBMapper
import com.greemoid.ithelps.domain.models.Mood
import com.greemoid.ithelps.domain.repository.MoodRepository

class MoodCacheDataSource(
    private val moodDao: MoodDao,
    private val mapperToDomain: MoodDBToMoodMapper,
    private val mapperToData: MoodToMoodDBMapper
) : MoodRepository {
    override fun getAllMoods(): List<Mood> {
        val list = moodDao.getAllMoods()
        return mapperToDomain.map(list)
    }

    override suspend fun insertMood(mood: Mood) {
        moodDao.insertMood(mapperToData.map(mood))
    }
}
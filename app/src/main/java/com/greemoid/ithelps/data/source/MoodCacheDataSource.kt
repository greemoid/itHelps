package com.greemoid.ithelps.data.source

import android.util.Log
import com.greemoid.ithelps.data.db.MoodDao
import com.greemoid.ithelps.data.mapper.mood.LastMoodDbToMoodMapper
import com.greemoid.ithelps.data.mapper.mood.MoodDBToMoodMapper
import com.greemoid.ithelps.data.mapper.mood.MoodToMoodDBMapper
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.repository.MoodRepository
import javax.inject.Inject

class MoodCacheDataSource @Inject constructor(
    private val moodDao: MoodDao,
    private val mapperToDomain: MoodDBToMoodMapper,
    private val mapperLastToDomain: LastMoodDbToMoodMapper,
    private val mapperToData: MoodToMoodDBMapper,
) : MoodRepository {
    override suspend fun getAllMoods(): List<Mood> {
        val list = moodDao.getAllMoods()
        return mapperToDomain.map(list)
    }

    //todo fix
    override suspend fun getLastMood(): Mood {
        var mood = Mood("", "", "")
        try {
            mood = mapperLastToDomain.map(moodDao.getLastMood())
        } catch (e: Exception) {
            Log.d("SOURCE", e.toString())
        }
        return mood
    }

    override suspend fun insertMood(mood: Mood) {
        moodDao.insertMood(mapperToData.map(mood))
    }
}
package com.greemoid.ithelps.data.source

import android.util.Log
import com.greemoid.ithelps.data.db.diaryDB.MeditationDao
import com.greemoid.ithelps.data.mapper.meditation.MeditationDBToMeditationMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationListMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationToMeditationDBMapper
import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.repository.MeditationRepository

class MeditationCacheDataSource(
    private val meditationDao: MeditationDao,
    private val meditationDBToMeditationMapper: MeditationDBToMeditationMapper,
    private val meditationToMeditationDBMapper: MeditationToMeditationDBMapper,
    private val meditationListMapper: MeditationListMapper,
) : MeditationRepository {
    override suspend fun insertMeditationTime(meditation: Meditation) {
        val meditationDB = meditationToMeditationDBMapper.map(meditation)
        meditationDao.insertMeditationTime(meditationDB)
    }

    override  fun getAllMeditationSessions(): List<Meditation> {
        val list = meditationDao.getAllMeditationSessions()
        return meditationListMapper.map(list)
    }

    override suspend fun getLastMeditationSession(): Meditation {
        val meditationDB = meditationDao.getLastMeditationSession()
        return meditationDBToMeditationMapper.map(meditationDB)
    }
}
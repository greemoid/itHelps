package com.greemoid.ithelps.data.source

import com.greemoid.ithelps.data.db.diaryDB.MeditationDao
import com.greemoid.ithelps.data.mapper.MeditationDBToMeditationMapper
import com.greemoid.ithelps.data.mapper.MeditationListMapper
import com.greemoid.ithelps.data.mapper.MeditationToMeditationDBMapper
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

    override fun getAllMeditationSessions(): List<Meditation> {
        val list = meditationDao.getAllMeditationSessions()
        return meditationListMapper.map(list)
    }

    override suspend fun getLastMeditationSession(): Meditation {
        val meditationDB = meditationDao.getLastMeditationSession()
        return meditationDBToMeditationMapper.map(meditationDB)
    }
}
package com.greemoid.ithelps.data.source

import android.util.Log
import com.greemoid.ithelps.data.db.MeditationDao
import com.greemoid.ithelps.data.mapper.meditation.MeditationDBToMeditationMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationListMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationToMeditationDBMapper
import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.repository.MeditationRepository
import javax.inject.Inject

class MeditationCacheDataSource @Inject constructor(
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

    //todo fix
    override suspend fun getLastMeditationSession(): Meditation {
        var meditation = Meditation(0, 0, 0, "")
        try {
            meditation =
                meditationDBToMeditationMapper.map(meditationDao.getLastMeditationSession())
        } catch (e: Exception) {
            Log.d("SOURCE", e.toString())
        }
        return meditation
    }
}
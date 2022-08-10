package com.greemoid.ithelps.data.db.diaryDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.greemoid.ithelps.data.models.MeditationTimeDB

@Dao
interface MeditationDao {

    @Insert
    suspend fun insertMeditationTime(meditationTimeDB: MeditationTimeDB)

    @Query("SELECT * FROM meditation_time_table")
    fun getAllMeditationSessions(): List<MeditationTimeDB>

    @Query("SELECT * FROM meditation_time_table ORDER BY id DESC LIMIT 1")
    suspend fun getLastMeditationSession(): MeditationTimeDB


}
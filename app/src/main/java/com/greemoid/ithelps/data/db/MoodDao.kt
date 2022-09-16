package com.greemoid.ithelps.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greemoid.ithelps.data.models.MoodDB

@Dao
interface MoodDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMood(moodDB: MoodDB)

    @Query("SELECT * FROM mood_table")
    suspend fun getAllMoods(): List<MoodDB>

    @Query("SELECT * FROM mood_table ORDER BY id DESC LIMIT 1")
    suspend fun getLastMood(): MoodDB
}
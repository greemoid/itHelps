package com.greemoid.ithelps.data.db.diaryDB

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
    fun getAllMoods(): List<MoodDB>
}
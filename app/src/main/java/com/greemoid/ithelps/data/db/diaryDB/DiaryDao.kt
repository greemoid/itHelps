package com.greemoid.ithelps.data.db.diaryDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greemoid.ithelps.data.models.DiaryNoteDB
import com.greemoid.ithelps.data.models.MoodDB

@Dao
interface DiaryDao {

    @Query("SELECT * FROM diary_table")
    fun getAllDiaryNotes(): List<DiaryNoteDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDiaryNote(diaryNote: DiaryNoteDB)

}

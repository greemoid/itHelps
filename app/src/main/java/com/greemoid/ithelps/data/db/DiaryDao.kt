package com.greemoid.ithelps.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greemoid.ithelps.data.models.DiaryNoteDB

@Dao
interface DiaryDao {

    @Query("SELECT * FROM diary_table")
    fun getAllDiaryNotes(): List<DiaryNoteDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDiaryNote(diaryNote: DiaryNoteDB)

}

package com.greemoid.ithelps.data.db.diaryDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.greemoid.ithelps.data.models.DiaryNoteDB
import com.greemoid.ithelps.data.models.MoodDB

@Database(entities = [DiaryNoteDB::class, MoodDB::class], version = 3)
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun getDiaryDao(): DiaryDao

    abstract fun getMoodDao(): MoodDao

}
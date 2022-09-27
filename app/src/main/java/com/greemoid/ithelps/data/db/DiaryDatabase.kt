package com.greemoid.ithelps.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.greemoid.ithelps.data.models.DiaryNoteDB
import com.greemoid.ithelps.data.models.MeditationTimeDB
import com.greemoid.ithelps.data.models.MoodDB
import com.greemoid.ithelps.data.models.TaskDB

@Database(entities = [DiaryNoteDB::class, MoodDB::class, TaskDB::class, MeditationTimeDB::class],
    version = 7)
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun getDiaryDao(): DiaryDao

    abstract fun getMoodDao(): MoodDao

    abstract fun getTasksDao(): TasksDao

    abstract fun getMeditationDao(): MeditationDao

}
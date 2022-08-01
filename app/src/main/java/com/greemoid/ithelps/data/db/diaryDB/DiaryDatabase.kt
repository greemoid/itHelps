package com.greemoid.ithelps.data.db.diaryDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.greemoid.ithelps.data.models.DiaryNoteDB

@Database(entities = [DiaryNoteDB::class], version = 1)
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun getDiaryDao(): DiaryDao

    companion object {
        private var database: DiaryDatabase? = null

        @Synchronized
        fun getInstance(context: Context): DiaryDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    DiaryDatabase::class.java,
                    "diary_table.db")
                    .build()
                database as DiaryDatabase
            } else {
                database as DiaryDatabase
            }
        }
    }
}
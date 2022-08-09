package com.greemoid.ithelps.di

import android.app.Application
import androidx.room.Room
import com.greemoid.ithelps.data.db.diaryDB.*
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val diaryDBModule = module {
    fun provideDataBase(application: Application): DiaryDatabase {
        return Room.databaseBuilder(application, DiaryDatabase::class.java, "diary_table.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDiaryDao(dataBase: DiaryDatabase): DiaryDao {
        return dataBase.getDiaryDao()
    }

    fun provideMoodDao(database: DiaryDatabase): MoodDao {
        return database.getMoodDao()
    }

    fun provideTasksDao(database: DiaryDatabase): TasksDao {
        return database.getTasksDao()
    }

    fun provideMeditationDao(database: DiaryDatabase): MeditationDao {
        return database.getMeditationDao()
    }

    single { provideDataBase(androidApplication()) }
    single { provideDiaryDao(get()) }
    single { provideMoodDao(get()) }
    single { provideTasksDao(get()) }
    single { provideMeditationDao(get()) }
}
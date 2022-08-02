package com.greemoid.ithelps.di

import android.app.Application
import androidx.room.Room
import com.greemoid.ithelps.data.db.diaryDB.DiaryDao
import com.greemoid.ithelps.data.db.diaryDB.DiaryDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val diaryDBModule = module {
    fun provideDataBase(application: Application): DiaryDatabase {
        return Room.databaseBuilder(application, DiaryDatabase::class.java, "diary_table.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: DiaryDatabase): DiaryDao {
        return dataBase.getDiaryDao()
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}
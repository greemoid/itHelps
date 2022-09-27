package com.greemoid.ithelps.di

import android.content.Context
import androidx.room.Room
import com.greemoid.ithelps.data.db.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DiaryDatabase =
        Room.databaseBuilder(context, DiaryDatabase::class.java, "diary_table.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Provides
    fun provideDiaryDao(dataBase: DiaryDatabase): DiaryDao =
        dataBase.getDiaryDao()


    @Provides
    fun provideMoodDao(database: DiaryDatabase): MoodDao =
        database.getMoodDao()


    @Provides
    fun provideTasksDao(database: DiaryDatabase): TasksDao =
        database.getTasksDao()


    @Provides
    fun provideMeditationDao(database: DiaryDatabase): MeditationDao =
        database.getMeditationDao()

}
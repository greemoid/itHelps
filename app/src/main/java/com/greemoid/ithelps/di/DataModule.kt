package com.greemoid.ithelps.di

import android.app.Application
import androidx.room.Room
import com.greemoid.ithelps.data.db.diaryDB.DiaryDao
import com.greemoid.ithelps.data.db.diaryDB.DiaryDatabase
import com.greemoid.ithelps.data.mapper.DiaryDBToDiaryNoteMapper
import com.greemoid.ithelps.data.mapper.DiaryNoteToDiaryDBMapper
import com.greemoid.ithelps.data.mapper.MoodDBToMoodMapper
import com.greemoid.ithelps.data.mapper.MoodToMoodDBMapper
import com.greemoid.ithelps.data.source.DiaryCacheDataSource
import com.greemoid.ithelps.data.source.MoodCacheDataSource
import com.greemoid.ithelps.domain.repository.DiaryRepository
import com.greemoid.ithelps.domain.repository.MoodRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single<DiaryRepository> {
        DiaryCacheDataSource(
            diaryDao = get(),
            mapperToDomain = DiaryDBToDiaryNoteMapper(),
            mapperToData = DiaryNoteToDiaryDBMapper()
        )
    }

    single<MoodRepository> {
        MoodCacheDataSource(
            moodDao = get(),
            mapperToDomain = MoodDBToMoodMapper(),
            mapperToData = MoodToMoodDBMapper()
        )
    }
}
package com.greemoid.ithelps.di

import com.greemoid.ithelps.data.mapper.*
import com.greemoid.ithelps.data.source.DiaryCacheDataSource
import com.greemoid.ithelps.data.source.MoodCacheDataSource
import com.greemoid.ithelps.data.source.TasksCacheDataSource
import com.greemoid.ithelps.domain.repository.DiaryRepository
import com.greemoid.ithelps.domain.repository.MoodRepository
import com.greemoid.ithelps.domain.repository.TaskRepository
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

    single<TaskRepository> {
        TasksCacheDataSource(
            tasksDao = get(),
            dataToDomainMapper = TaskDBToTaskMapper(),
            domainToDataMapper = TaskToTaskDBMapper()
        )
    }
}
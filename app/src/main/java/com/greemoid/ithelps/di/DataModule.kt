package com.greemoid.ithelps.di

import com.greemoid.ithelps.data.mapper.diary.DiaryDBToDiaryNoteMapper
import com.greemoid.ithelps.data.mapper.diary.DiaryNoteToDiaryDBMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationDBToMeditationMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationListMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationToMeditationDBMapper
import com.greemoid.ithelps.data.mapper.mood.MoodDBToMoodMapper
import com.greemoid.ithelps.data.mapper.mood.MoodToMoodDBMapper
import com.greemoid.ithelps.data.mapper.todo.TaskDBToTaskMapper
import com.greemoid.ithelps.data.mapper.todo.TaskToTaskDBMapper
import com.greemoid.ithelps.data.source.DiaryCacheDataSource
import com.greemoid.ithelps.data.source.MeditationCacheDataSource
import com.greemoid.ithelps.data.source.MoodCacheDataSource
import com.greemoid.ithelps.data.source.TasksCacheDataSource
import com.greemoid.ithelps.domain.repository.DiaryRepository
import com.greemoid.ithelps.domain.repository.MeditationRepository
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

    single<MeditationRepository> {
        MeditationCacheDataSource(
            meditationDao = get(),
            meditationDBToMeditationMapper = MeditationDBToMeditationMapper(),
            meditationToMeditationDBMapper = MeditationToMeditationDBMapper(),
            meditationListMapper = MeditationListMapper()
        )
    }
}
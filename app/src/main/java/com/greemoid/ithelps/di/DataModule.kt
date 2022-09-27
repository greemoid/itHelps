package com.greemoid.ithelps.di

import com.greemoid.ithelps.data.db.DiaryDao
import com.greemoid.ithelps.data.db.MeditationDao
import com.greemoid.ithelps.data.db.MoodDao
import com.greemoid.ithelps.data.db.TasksDao
import com.greemoid.ithelps.data.mapper.diary.DiaryDBToDiaryNoteMapper
import com.greemoid.ithelps.data.mapper.diary.DiaryNoteToDiaryDBMapper
import com.greemoid.ithelps.data.mapper.diary.LastDiaryNoteDBToNoteMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationDBToMeditationMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationListMapper
import com.greemoid.ithelps.data.mapper.meditation.MeditationToMeditationDBMapper
import com.greemoid.ithelps.data.mapper.mood.LastMoodDbToMoodMapper
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDiaryDataSource(diaryDao: DiaryDao): DiaryRepository =
        DiaryCacheDataSource(
            diaryDao = diaryDao,
            mapperToDomain = DiaryDBToDiaryNoteMapper(),
            lastMapperToDomain = LastDiaryNoteDBToNoteMapper(),
            mapperToData = DiaryNoteToDiaryDBMapper()
        )

    @Provides
    @Singleton
    fun provideMoodCacheDataSource(moodDao: MoodDao): MoodRepository =
        MoodCacheDataSource(
            moodDao = moodDao,
            mapperToDomain = MoodDBToMoodMapper(),
            mapperLastToDomain = LastMoodDbToMoodMapper(),
            mapperToData = MoodToMoodDBMapper()
        )

    @Provides
    @Singleton
    fun provideTaskCacheDataSource(tasksDao: TasksDao): TaskRepository =
        TasksCacheDataSource(
            tasksDao = tasksDao,
            dataToDomainMapper = TaskDBToTaskMapper(),
            domainToDataMapper = TaskToTaskDBMapper()
        )

    @Provides
    @Singleton
    fun provideMeditationDataSource(meditationDao: MeditationDao): MeditationRepository =
        MeditationCacheDataSource(
            meditationDao = meditationDao,
            meditationDBToMeditationMapper = MeditationDBToMeditationMapper(),
            meditationToMeditationDBMapper = MeditationToMeditationDBMapper(),
            meditationListMapper = MeditationListMapper()
        )
}
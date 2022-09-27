package com.greemoid.ithelps.di

import com.greemoid.ithelps.domain.repository.DiaryRepository
import com.greemoid.ithelps.domain.repository.MeditationRepository
import com.greemoid.ithelps.domain.repository.MoodRepository
import com.greemoid.ithelps.domain.repository.TaskRepository
import com.greemoid.ithelps.domain.usecases.diary.GetAllDiaryNotesUseCase
import com.greemoid.ithelps.domain.usecases.diary.GetLastDiaryNoteUseCase
import com.greemoid.ithelps.domain.usecases.diary.SaveDiaryNoteUseCase
import com.greemoid.ithelps.domain.usecases.meditation.GetAllMeditationSessionsUseCase
import com.greemoid.ithelps.domain.usecases.meditation.GetLastMeditationSessionUseCase
import com.greemoid.ithelps.domain.usecases.meditation.SaveMeditationSessionUseCase
import com.greemoid.ithelps.domain.usecases.mood.GetAllMoodsUseCase
import com.greemoid.ithelps.domain.usecases.mood.GetLastMoodUseCase
import com.greemoid.ithelps.domain.usecases.mood.SaveMoodUseCase
import com.greemoid.ithelps.domain.usecases.todo.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideSaveDiaryNoteUseCase(diaryRepository: DiaryRepository) =
        SaveDiaryNoteUseCase(diaryRepository = diaryRepository)

    @Provides
    fun provideSaveMoodUseCase(moodRepository: MoodRepository) =
        SaveMoodUseCase(moodRepository = moodRepository)

    @Provides
    fun provideSaveTaskUseCase(taskRepository: TaskRepository) =
        SaveTaskUseCase(taskRepository = taskRepository)

    @Provides
    fun provideGetAllTasksUseCase(taskRepository: TaskRepository) =
        GetAllTasksUseCase(taskRepository = taskRepository)

    @Provides
    fun provideGetTasksByTaskTypeUseCase(taskRepository: TaskRepository) =
        GetTasksByTaskTypeUseCase(taskRepository = taskRepository)

    @Provides
    fun provideDeleteTaskUseCase(taskRepository: TaskRepository) =
        DeleteTaskUseCase(taskRepository = taskRepository)

    @Provides
    fun provideUpdateTaskUseCase(taskRepository: TaskRepository) =
        UpdateTaskUseCase(repository = taskRepository)

    @Provides
    fun provideSaveMeditationSessionUseCase(meditationRepository: MeditationRepository) =
        SaveMeditationSessionUseCase(meditationRepository = meditationRepository)

    @Provides
    fun provideGetLastMeditationSessionUseCase(meditationRepository: MeditationRepository) =
        GetLastMeditationSessionUseCase(meditationRepository = meditationRepository)

    @Provides
    fun provideGetAllMeditationSessionsUseCase(meditationRepository: MeditationRepository) =
        GetAllMeditationSessionsUseCase(meditationRepository = meditationRepository)

    @Provides
    fun provideGetAllMoodsUseCase(moodRepository: MoodRepository) =
        GetAllMoodsUseCase(moodRepository = moodRepository)

    @Provides
    fun provideGetAllDiaryNotesUseCase(diaryRepository: DiaryRepository) =
        GetAllDiaryNotesUseCase(diaryRepository = diaryRepository)

    @Provides
    fun provideGetLastMoodUseCase(moodRepository: MoodRepository) =
        GetLastMoodUseCase(moodRepository = moodRepository)

    @Provides
    fun provideGetLastDiaryNoteUseCase(diaryRepository: DiaryRepository) =
        GetLastDiaryNoteUseCase(diaryRepository = diaryRepository)

}

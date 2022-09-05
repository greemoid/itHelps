package com.greemoid.ithelps.di

import com.greemoid.ithelps.domain.usecases.diary.GetAllDiaryNotesUseCase
import com.greemoid.ithelps.domain.usecases.diary.SaveDiaryNoteUseCase
import com.greemoid.ithelps.domain.usecases.meditation.GetAllMeditationSessionsUseCase
import com.greemoid.ithelps.domain.usecases.meditation.GetLastMeditationSessionUseCase
import com.greemoid.ithelps.domain.usecases.meditation.SaveMeditationSessionUseCase
import com.greemoid.ithelps.domain.usecases.mood.GetAllMoodsUseCase
import com.greemoid.ithelps.domain.usecases.mood.SaveMoodUseCase
import com.greemoid.ithelps.domain.usecases.todo.*
import org.koin.dsl.module

val domainModule = module {

    single {
        SaveDiaryNoteUseCase(
            diaryRepository = get()
        )
    }

    single {
        SaveMoodUseCase(
            moodRepository = get()
        )
    }

    single {
        SaveTaskUseCase(
            taskRepository = get()
        )
    }

    single {
        GetAllTasksUseCase(
            taskRepository = get()
        )
    }

    single {
        GetTasksByTaskTypeUseCase(
            taskRepository = get()
        )
    }

    single {
        DeleteTaskUseCase(
            taskRepository = get()
        )
    }

    single {
        UpdateTaskUseCase(
            repository = get()
        )
    }

    single {
        SaveMeditationSessionUseCase(
            meditationRepository = get()
        )
    }

    single {
        GetLastMeditationSessionUseCase(
            meditationRepository = get()
        )
    }

    single {
        GetAllMeditationSessionsUseCase(
            meditationRepository = get()
        )
    }

    single {
        GetAllMoodsUseCase(
            moodRepository = get()
        )
    }

    single {
        GetAllDiaryNotesUseCase(
            diaryRepository = get()
        )
    }

}
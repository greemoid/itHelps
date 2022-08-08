package com.greemoid.ithelps.di

import com.greemoid.ithelps.domain.usecases.*
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
}
package com.greemoid.ithelps.di

import com.greemoid.ithelps.data.mapper.TaskToTaskDBMapper
import com.greemoid.ithelps.presentation.core.Date
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import com.greemoid.ithelps.presentation.diary.DiaryViewModel
import com.greemoid.ithelps.presentation.instruments.breathing.ExerciseBreathingViewModel
import com.greemoid.ithelps.presentation.meditation.MeditationViewModel
import com.greemoid.ithelps.presentation.moodAdd.MoodAddViewModel
import com.greemoid.ithelps.presentation.todo.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single {
        TodoTasksAdapter(
            viewModel = get()
        )
    }

    viewModel {
        DiaryViewModel(
            useCase = get(),
            date = Date()
        )
    }

    viewModel {
        DailyTasksViewModel(
            date = Date()
        )
    }

    viewModel {
        MoodAddViewModel(
            useCase = get(),
            date = Date()
        )
    }

    viewModel {
        TodoAddViewModel(
            saveTaskUseCase = get()
        )
    }

    viewModel {
        TodoListTasksViewModel(
            getAllTasksUseCase = get(),
            getTasksByTaskTypeUseCase = get(),
            updateTaskUseCase = get()
        )
    }

    viewModel {
        MeditationViewModel(
            saveMeditationSessionUseCase = get(),
            date = Date(),
            getLastMeditationSessionUseCase = get(),
            context = get()
        )
    }

    viewModel {
        TaskItemViewModel(
            useCase = get()
        )
    }

    viewModel {
        UpdateViewModel(
            updateTaskUseCase = get()
        )
    }

    viewModel {
        ExerciseBreathingViewModel()
    }

}
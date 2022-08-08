package com.greemoid.ithelps.di

import com.greemoid.ithelps.presentation.core.Date
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import com.greemoid.ithelps.presentation.diary.DiaryViewModel
import com.greemoid.ithelps.presentation.meditation.MeditationViewModel
import com.greemoid.ithelps.presentation.moodAdd.MoodAddViewModel
import com.greemoid.ithelps.presentation.todo.TaskItemViewModel
import com.greemoid.ithelps.presentation.todo.TodoAddViewModel
import com.greemoid.ithelps.presentation.todo.TodoListTasksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

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
            getTasksByTaskTypeUseCase = get()
        )
    }

    viewModel {
        MeditationViewModel()
    }

    viewModel {
        TaskItemViewModel(
            useCase = get()
        )
    }
}
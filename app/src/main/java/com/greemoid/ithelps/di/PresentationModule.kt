package com.greemoid.ithelps.di

import com.greemoid.ithelps.presentation.core.Date
import com.greemoid.ithelps.presentation.core.VibratorManager
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import com.greemoid.ithelps.presentation.diary.DiaryViewModel
import com.greemoid.ithelps.presentation.insights.InsightsViewModel
import com.greemoid.ithelps.presentation.insights.diary.DiaryListViewModel
import com.greemoid.ithelps.presentation.insights.mood.MoodListViewModel
import com.greemoid.ithelps.presentation.instruments.breathing.ExerciseBreathingViewModel
import com.greemoid.ithelps.presentation.meditation.MeditationViewModel
import com.greemoid.ithelps.presentation.moodAdd.MoodAddViewModel
import com.greemoid.ithelps.presentation.todo.add.TodoAddViewModel
import com.greemoid.ithelps.presentation.todo.item.TaskItemViewModel
import com.greemoid.ithelps.presentation.todo.list.TodoListTasksViewModel
import com.greemoid.ithelps.presentation.todo.list.TodoTasksAdapter
import com.greemoid.ithelps.presentation.todo.update.UpdateViewModel
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
            getLastMeditationSessionUseCase = get(),
            getLastMoodUseCase = get(),
            getLastDiaryNoteUseCase = get(),
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
            baseVibratorManager = VibratorManager(context = get())
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

    viewModel {
        InsightsViewModel(
            getAllMoodsUseCase = get(),
            getAllDiaryNotesUseCase = get()
        )
    }

    viewModel {
        DiaryListViewModel(
            getAllDiaryNotesUseCase = get()
        )
    }

    viewModel {
        MoodListViewModel(
            getAllMoodsUseCase = get()
        )
    }
}
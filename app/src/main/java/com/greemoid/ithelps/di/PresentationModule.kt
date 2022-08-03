package com.greemoid.ithelps.di

import com.greemoid.ithelps.presentation.core.Date
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import com.greemoid.ithelps.presentation.diary.DiaryViewModel
import com.greemoid.ithelps.presentation.moodAdd.MoodAddViewModel
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
}
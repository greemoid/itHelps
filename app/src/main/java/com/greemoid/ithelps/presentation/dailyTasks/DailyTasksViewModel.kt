package com.greemoid.ithelps.presentation.dailyTasks

import androidx.lifecycle.ViewModel
import com.greemoid.ithelps.presentation.core.Date

class DailyTasksViewModel(
    date: Date,
) : ViewModel() {

    val day = date.getCurrentDayAndDate()

}
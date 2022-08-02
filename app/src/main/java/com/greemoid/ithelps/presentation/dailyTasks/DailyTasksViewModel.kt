package com.greemoid.ithelps.presentation.dailyTasks

import androidx.lifecycle.ViewModel
import com.greemoid.ithelps.presentation.core.Date
import java.text.SimpleDateFormat
import java.util.*

class DailyTasksViewModel(
    private val date: Date
) : ViewModel() {

    val day = date.getCurrentDayAndDate()
}
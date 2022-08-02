package com.greemoid.ithelps.presentation.dailyTasks

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class DailyTasksViewModel : ViewModel() {

    fun getCurrentDate() : String {
        val date = getCurrentDateTime().toString("dd")
        val day = getCurrentDay()
        return "$day, $date"
    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    private fun getCurrentDay(): String {
        val calendar = Calendar.getInstance()
        val date = calendar.time
        return SimpleDateFormat("EEEE", Locale.getDefault()).format(date.time)
    }

}
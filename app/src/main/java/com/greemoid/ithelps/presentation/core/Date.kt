package com.greemoid.ithelps.presentation.core

import org.joda.time.Days
import java.text.SimpleDateFormat
import java.util.*
import java.util.Date

class Date {

    fun getCurrentDayAndDate() : String {
        val date = getCurrentDateTime().toString("dd")
        val day = getCurrentDay()
        return "$day, $date"
    }

    fun getCurrentFullDate() : String {
        return getCurrentDateTime().toString("dd.MM.yyyy")
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
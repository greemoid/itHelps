package com.greemoid.ithelps.presentation.meditation

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MeditationViewModel : ViewModel() {

    /*private val _millisL: Long = 0
    val millis: LiveData<Long> = _millis

    fun addFiveMinutes(millis: LiveData<Long>): String {
        millis.value?.minus(30000)
        return convert(millis)
    }

    fun minusFiveMinutes(millis: LiveData<Long>): String {
        millis.value?.plus(30000)
        return convert(millis)
    }



    private fun convert(millis: Long): String {

        val seconds = millis / 1000
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60

        return String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)
    }*/
}
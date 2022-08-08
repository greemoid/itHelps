package com.greemoid.ithelps.presentation.meditation

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.properties.Delegates

class MeditationViewModel : ViewModel() {

    private val _millis = MutableLiveData<String>("")
    val millis: LiveData<String> = _millis
    lateinit var timer: CountDownTimer

    fun startTimer(time: Long) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _millis.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)
            }

            override fun onFinish() {
                _millis.value = "Done!"
            }
        }.start()
    }

    fun cancelTimer() {
        timer.cancel()
    }
}
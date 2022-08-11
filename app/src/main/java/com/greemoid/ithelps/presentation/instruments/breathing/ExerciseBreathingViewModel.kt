package com.greemoid.ithelps.presentation.instruments.breathing


import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ExerciseBreathingViewModel: ViewModel() {

    private val _millisBreath = MutableLiveData<String>("")
    val millisBreath: LiveData<String> = _millisBreath
    private val _totalTime = MutableLiveData<String>("")
    val totalTime: LiveData<String> = _totalTime
    private val _breath = MutableLiveData<String>("")
    val breath: LiveData<String> = _breath
    private val _breathTimeForAnim = MutableLiveData<Long>(0)
    val breathTimeForAnim: LiveData<Long> = _breathTimeForAnim

    /*
    private val _isBreathTimer = MutableLiveData(false)
    val isBreathTimer: LiveData<Boolean> = _isBreathTimer
    private val _isFirstDelayTimer = MutableLiveData(false)
    val isFirstDelayTimer: LiveData<Boolean> = _isFirstDelayTimer
    val isSecondDelayTimer: LiveData<Boolean> = _isSecondDelayTimer*/

    private val _isBreathTimer = MutableLiveData(false)
    val isBreathTimer: LiveData<Boolean> = _isBreathTimer


    private val _isExhalationTimer = MutableLiveData(false)
    val isExhalationTimer: LiveData<Boolean> = _isExhalationTimer

    lateinit var totalTimer: CountDownTimer
    lateinit var breathTimer: CountDownTimer
    lateinit var firstDelayTimer: CountDownTimer
    lateinit var exhalationTimer: CountDownTimer
    lateinit var secondDelayTimer: CountDownTimer


    fun startTotalTimer(
        time: Int,
        breath: Int,
        firstDelay: Int,
        exhalation: Int,
        secondDelay: Int,
    ) {
        var totalTime: Long = 0
        val time = (time * 1000).toLong()

        totalTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _totalTime.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)

            }

            override fun onFinish() {
                _millisBreath.value = "Done!"
            }
        }.start()
    }

    fun cancelTimer() {
        totalTimer.cancel()
    }

    fun startBreathTimer(breath: Int, firstDelay: Int, exhalation: Int, secondDelay: Int) {
        val time = ((breath + 1) * 1000).toLong()
        _breathTimeForAnim.value = time
        _isBreathTimer.value = true
        breathTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%1d", secs)/*
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)*/
                _breath.value = "Вдихай"
            }

            override fun onFinish() {
                _isBreathTimer.value = false
                startFirstDelayTimer(breath, firstDelay, exhalation, secondDelay)
            }
        }.start()
    }

    fun startFirstDelayTimer(breath: Int, firstDelay: Int, exhalation: Int, secondDelay: Int) {
        val time = ((firstDelay + 1) * 1000).toLong()
        firstDelayTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%1d", secs)/*
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)*/
                _breath.value = "Затримай"
            }

            override fun onFinish() {
                startExhalationTimer(breath, firstDelay, exhalation, secondDelay)
            }
        }.start()
    }

    fun startExhalationTimer(breath: Int, firstDelay: Int, exhalation: Int, secondDelay: Int) {
        val time = ((exhalation + 1) * 1000).toLong()
        _breathTimeForAnim.value = time
        _isExhalationTimer.value = true
        exhalationTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%1d", secs)/*
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)*/
                _breath.value = "Видихай"
            }

            override fun onFinish() {
                _isExhalationTimer.value = false
                startSecondDelayTimer(breath, firstDelay, exhalation, secondDelay)
            }
        }.start()
    }

    fun startSecondDelayTimer(breath: Int, firstDelay: Int, exhalation: Int, secondDelay: Int) {
        val time = ((secondDelay + 1) * 1000).toLong()
        secondDelayTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%1d", secs)/*
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _millisBreath.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)*/
                _breath.value = "Затримай"
            }

            override fun onFinish() {
                startBreathTimer(breath, firstDelay, exhalation, secondDelay)
            }
        }.start()
    }
}
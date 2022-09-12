package com.greemoid.ithelps.presentation.meditation

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.core.presentation.BaseVibratorManager
import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.usecases.meditation.GetLastMeditationSessionUseCase
import com.greemoid.ithelps.domain.usecases.meditation.SaveMeditationSessionUseCase
import com.greemoid.ithelps.presentation.core.Date
import kotlinx.coroutines.launch
import java.util.*

class MeditationViewModel(
    private val saveMeditationSessionUseCase: SaveMeditationSessionUseCase,
    private val getLastMeditationSessionUseCase: GetLastMeditationSessionUseCase,
    private val date: Date,
    private val baseVibratorManager: BaseVibratorManager,
) : ViewModel() {


    private val _millis = MutableLiveData<String>("")
    val millis: LiveData<String> = _millis

    private var timer: CountDownTimer? = null

    fun startTimer(time: Long) {
        var totalTime: Long = 0

        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _millis.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)
            }

            override fun onFinish() {
                _millis.value = "Done!"
                //todo тут ошибка якшо береться вперше з бази даних то крашиться аппка
                viewModelScope.launch {
                    totalTime =
                        getLastMeditationSessionUseCase.getLastMeditationSession().totalTime + time
                }
                viewModelScope.launch {
                    val meditation = Meditation(
                        sessionTime = time,
                        totalTime = totalTime,
                        date = date.getCurrentFullDate()
                    )
                    baseVibratorManager.vibrate()
                    saveMeditationSessionUseCase.saveMeditationSession(meditation)
                }

            }
        }.start()
    }

    fun cancelTimer() {
        timer?.cancel()
    }


}
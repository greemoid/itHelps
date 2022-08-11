package com.greemoid.ithelps.presentation.meditation

import android.content.Context
import android.os.Build
import android.os.CountDownTimer
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val context: Context
) : ViewModel() {

    /*
     * What I ended up doing instead of having a Context directly in the ViewModel,
     * I made provider classes such as ResourceProvider that would give me the resources I need,
     * and I had those provider classes injected into my ViewModel
     */

    private val _millis = MutableLiveData<String>("")
    val millis: LiveData<String> = _millis
    lateinit var timer: CountDownTimer

    fun startTimer(time: Long) {
        var totalTime: Long = 0
        viewModelScope.launch {
            Log.d("TOTALTIME","${getLastMeditationSessionUseCase.getLastMeditationSession().totalTime + time}")
            totalTime =  getLastMeditationSessionUseCase.getLastMeditationSession().totalTime + time
        }
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _millis.value = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs)
            }

            override fun onFinish() {
                _millis.value = "Done!"

                viewModelScope.launch {
                    val meditation = Meditation(
                        sessionTime = time,
                        totalTime = totalTime,
                        date = date.getCurrentFullDate()
                    )
                    saveMeditationSessionUseCase.saveMeditationSession(meditation)
                }
                val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    vibrator.vibrate(400)
                }
            }
        }.start()
    }

    fun cancelTimer() {
        timer.cancel()
    }



}
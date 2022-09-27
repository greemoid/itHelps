package com.greemoid.ithelps.presentation.dailyTasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.usecases.diary.GetLastDiaryNoteUseCase
import com.greemoid.ithelps.domain.usecases.meditation.GetLastMeditationSessionUseCase
import com.greemoid.ithelps.domain.usecases.mood.GetLastMoodUseCase
import com.greemoid.ithelps.presentation.core.Date
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DailyTasksViewModel @Inject constructor(
    private val getLastMeditationSessionUseCase: GetLastMeditationSessionUseCase,
    private val getLastMoodUseCase: GetLastMoodUseCase,
    private val getLastDiaryNoteUseCase: GetLastDiaryNoteUseCase,
    private val date: Date,
) : ViewModel() {
    val day = date.getCurrentDayAndDate()

    private val _meditation = MutableLiveData<Boolean>()
    val meditation: LiveData<Boolean> = _meditation

    private val _mood = MutableLiveData<Boolean>()
    val mood: LiveData<Boolean> = _mood

    private val _note = MutableLiveData<Boolean>()
    val note: LiveData<Boolean> = _note

    fun update() {
        getLastMeditationSession()
        getLastMood()
        getLastDiaryNote()
    }

    fun getLastMeditationSession() {
        viewModelScope.launch {
            _meditation.value =
                getLastMeditationSessionUseCase.getLastMeditationSession().date.equals(date.getCurrentFullDate())
        }
    }

    fun getLastDiaryNote() {
        viewModelScope.launch {
            _note.value =
                getLastDiaryNoteUseCase.getLastNote().date.equals(date.getCurrentFullDate())
        }
    }

    fun getLastMood() {
        viewModelScope.launch {
            _mood.value =
                getLastMoodUseCase.getLastMood().date.equals(date.getCurrentFullDate())
        }
    }

}
package com.greemoid.ithelps.presentation.moodAdd

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.Mood
import com.greemoid.ithelps.domain.usecases.SaveMoodUseCase
import com.greemoid.ithelps.presentation.core.Date
import kotlinx.coroutines.launch

class MoodAddViewModel(
    private val useCase: SaveMoodUseCase,
    date: Date
) : ViewModel() {

    val fullyDate = date.getCurrentFullDate()

    fun save(mood: Mood) {
        viewModelScope.launch {
            Log.d("SAVE", useCase.saveMood(mood).toString())
        }
    }
}
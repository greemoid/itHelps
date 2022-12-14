package com.greemoid.ithelps.presentation.moodAdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.usecases.mood.SaveMoodUseCase
import com.greemoid.ithelps.presentation.core.Date
import kotlinx.coroutines.launch

class MoodAddViewModel(
    private val useCase: SaveMoodUseCase,
    date: Date,
) : ViewModel() {

    val fullyDate = date.getCurrentFullDate()

    fun save(mood: Mood) {
        viewModelScope.launch {
            useCase.saveMood(mood).toString()
        }
    }
}
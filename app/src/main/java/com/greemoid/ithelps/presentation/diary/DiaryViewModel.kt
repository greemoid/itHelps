package com.greemoid.ithelps.presentation.diary

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.usecases.diary.SaveDiaryNoteUseCase
import com.greemoid.ithelps.presentation.core.Date
import kotlinx.coroutines.launch

class DiaryViewModel(
    private val useCase: SaveDiaryNoteUseCase,
    date: Date,
) : ViewModel() {

    val fullyDate = date.getCurrentFullDate()
    val currentDay = date.getCurrentDayAndDate()

    fun save(diaryNote: DiaryNote) {
        viewModelScope.launch {
            Log.d("SAVE", useCase.saveDiaryNote(diaryNote).toString())
        }
    }
}
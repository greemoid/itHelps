package com.greemoid.ithelps.presentation.insights

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.models.meditation.Meditation
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.usecases.diary.GetAllDiaryNotesUseCase
import com.greemoid.ithelps.domain.usecases.meditation.GetAllMeditationSessionsUseCase
import com.greemoid.ithelps.domain.usecases.mood.GetAllMoodsUseCase
import kotlinx.coroutines.launch

class InsightsViewModel(
    private val getAllMoodsUseCase: GetAllMoodsUseCase,
    private val getAllDiaryNotesUseCase: GetAllDiaryNotesUseCase,
    private val getAllMeditationSessionsUseCase: GetAllMeditationSessionsUseCase,
) : ViewModel() {

    private var _listMoods = MutableLiveData<List<Mood>>()
    val listMoods: LiveData<List<Mood>> get() = _listMoods

    private var _listDiary = MutableLiveData<List<DiaryNote>>()
    val listDiary: LiveData<List<DiaryNote>> get() = _listDiary


    private var _listMeditations = MutableLiveData<List<Meditation>>()
    val listMeditations: LiveData<List<Meditation>> get() = _listMeditations

    init {
        getAllMoods()
        getAllNotes()
        getAllMeditations()
    }


    private fun getAllMoods() {
        viewModelScope.launch {
            _listMoods.value = getAllMoodsUseCase.getAllMoods()
        }
    }

    private fun getAllNotes() {
        viewModelScope.launch {
            _listDiary.value = getAllDiaryNotesUseCase.getAllDiaryNotes()
            Log.d("TAG", getAllDiaryNotesUseCase.getAllDiaryNotes().toString())
        }
    }

    private fun getAllMeditations() {
            _listMeditations.value = getAllMeditationSessionsUseCase.getAllMeditationSessions()
            Log.d("TAG", getAllMeditationSessionsUseCase.getAllMeditationSessions().toString())

    }

}
package com.greemoid.ithelps.presentation.insights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.usecases.diary.GetAllDiaryNotesUseCase
import com.greemoid.ithelps.domain.usecases.mood.GetAllMoodsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsightsViewModel @Inject constructor(
    private val getAllMoodsUseCase: GetAllMoodsUseCase,
    private val getAllDiaryNotesUseCase: GetAllDiaryNotesUseCase,
) : ViewModel() {

    private var _listMoods = MutableLiveData<List<Mood>>()
    val listMoods: LiveData<List<Mood>> get() = _listMoods

    private var _listDiary = MutableLiveData<List<DiaryNote>>()
    val listDiary: LiveData<List<DiaryNote>> get() = _listDiary


    init {
        getAllMoods()
        getAllNotes()
    }


    private fun getAllMoods() {
        viewModelScope.launch {
            _listMoods.value = getAllMoodsUseCase.getAllMoods()
        }
    }

    private fun getAllNotes() {
        viewModelScope.launch {
            _listDiary.value = getAllDiaryNotesUseCase.getAllDiaryNotes()
        }
    }
}
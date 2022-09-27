package com.greemoid.ithelps.presentation.insights.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.usecases.diary.GetAllDiaryNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiaryListViewModel @Inject constructor(
    private val getAllDiaryNotesUseCase: GetAllDiaryNotesUseCase,
) : ViewModel() {

    private var _listDiary = MutableLiveData<List<DiaryNote>>()
    val listDiary: LiveData<List<DiaryNote>> get() = _listDiary

    init {
        getAllNotes()
    }


    private fun getAllNotes() {
        viewModelScope.launch {
            _listDiary.value = getAllDiaryNotesUseCase.getAllDiaryNotes()
        }
    }
}
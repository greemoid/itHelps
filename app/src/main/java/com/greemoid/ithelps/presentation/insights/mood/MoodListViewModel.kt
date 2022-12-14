package com.greemoid.ithelps.presentation.insights.mood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.usecases.mood.GetAllMoodsUseCase
import kotlinx.coroutines.launch

class MoodListViewModel(
    private val getAllMoodsUseCase: GetAllMoodsUseCase,
) : ViewModel() {

    private var _listMoods = MutableLiveData<List<Mood>>()
    val listMoods: LiveData<List<Mood>> get() = _listMoods

    init {
        getAllMoods()
    }

    private fun getAllMoods() {
        viewModelScope.launch {
            _listMoods.value = getAllMoodsUseCase.getAllMoods()
        }
    }
}
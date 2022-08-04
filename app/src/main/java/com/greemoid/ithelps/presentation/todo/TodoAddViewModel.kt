package com.greemoid.ithelps.presentation.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.Task
import com.greemoid.ithelps.domain.usecases.SaveTaskUseCase
import kotlinx.coroutines.launch

class TodoAddViewModel(
    private val saveTaskUseCase: SaveTaskUseCase
): ViewModel() {

    fun saveTask(task: Task) {
        viewModelScope.launch {
            saveTaskUseCase.saveTask(task)
        }
    }
}
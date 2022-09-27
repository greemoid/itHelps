package com.greemoid.ithelps.presentation.todo.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.domain.models.todo.Task
import com.greemoid.ithelps.domain.usecases.todo.SaveTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoAddViewModel @Inject constructor(
    private val saveTaskUseCase: SaveTaskUseCase,
) : ViewModel() {

    fun saveTask(task: Task) {
        viewModelScope.launch {
            saveTaskUseCase.saveTask(task)
        }
    }
}
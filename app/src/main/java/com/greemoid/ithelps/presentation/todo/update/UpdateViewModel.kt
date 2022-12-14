package com.greemoid.ithelps.presentation.todo.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.usecases.todo.UpdateTaskUseCase
import kotlinx.coroutines.launch

class UpdateViewModel(
    private val updateTaskUseCase: UpdateTaskUseCase,
) : ViewModel() {

    fun updateTask(task: TaskDB) {
        viewModelScope.launch {
            updateTaskUseCase.updateTask(task)
        }
    }

}
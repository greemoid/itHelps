package com.greemoid.ithelps.presentation.todo.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.usecases.todo.DeleteTaskUseCase
import kotlinx.coroutines.launch

class TaskItemViewModel(
    private val useCase: DeleteTaskUseCase,
) : ViewModel() {

    fun delete(task: TaskDB) {
        viewModelScope.launch {
            useCase.deleteTask(task)
        }
    }
}
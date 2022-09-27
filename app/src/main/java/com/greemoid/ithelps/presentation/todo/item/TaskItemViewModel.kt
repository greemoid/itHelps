package com.greemoid.ithelps.presentation.todo.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.usecases.todo.DeleteTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskItemViewModel @Inject constructor(
    private val useCase: DeleteTaskUseCase,
) : ViewModel() {

    fun delete(task: TaskDB) {
        viewModelScope.launch {
            useCase.deleteTask(task)
        }
    }
}
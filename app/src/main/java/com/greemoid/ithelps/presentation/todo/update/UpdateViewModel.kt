package com.greemoid.ithelps.presentation.todo.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.usecases.todo.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(
    private val updateTaskUseCase: UpdateTaskUseCase,
) : ViewModel() {

    fun updateTask(task: TaskDB) {
        viewModelScope.launch {
            updateTaskUseCase.updateTask(task)
        }
    }

}
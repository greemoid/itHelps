package com.greemoid.ithelps.presentation.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.models.Task
import com.greemoid.ithelps.domain.usecases.GetAllTasksUseCase
import com.greemoid.ithelps.domain.usecases.GetTasksByTaskTypeUseCase
import com.greemoid.ithelps.domain.usecases.UpdateTaskUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoListTasksViewModel(
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val getTasksByTaskTypeUseCase: GetTasksByTaskTypeUseCase,
) : ViewModel() {


    private val _list = MutableLiveData<List<TaskDB>>()
    val list: LiveData<List<TaskDB>> = _list

    fun getByType(taskType: String) : LiveData<List<TaskDB>> {
        return getTasksByTaskTypeUseCase.getTasksByTasksType(taskType)
    }

    fun update(taskDB: TaskDB) {
        viewModelScope.launch {
            updateTaskUseCase.updateTask(taskDB)
        }
    }
}
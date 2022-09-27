package com.greemoid.ithelps.presentation.todo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.usecases.todo.GetAllTasksUseCase
import com.greemoid.ithelps.domain.usecases.todo.GetTasksByTaskTypeUseCase
import com.greemoid.ithelps.domain.usecases.todo.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListTasksViewModel @Inject constructor(
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val getTasksByTaskTypeUseCase: GetTasksByTaskTypeUseCase,
) : ViewModel() {


    private val _list = MutableLiveData<List<TaskDB>>()
    val list: LiveData<List<TaskDB>> = _list

    fun getByType(taskType: String): LiveData<List<TaskDB>> {
        return getTasksByTaskTypeUseCase.getTasksByTasksType(taskType)
    }

    fun update(taskDB: TaskDB) {
        viewModelScope.launch {
            updateTaskUseCase.updateTask(taskDB)
        }
    }
}
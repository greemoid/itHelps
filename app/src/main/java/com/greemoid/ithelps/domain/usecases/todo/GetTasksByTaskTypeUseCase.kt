package com.greemoid.ithelps.domain.usecases.todo

import androidx.lifecycle.LiveData
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.repository.TaskRepository

class GetTasksByTaskTypeUseCase(
    private val taskRepository: TaskRepository
) {

    fun getTasksByTasksType(taskType: String): LiveData<List<TaskDB>> {
        return taskRepository.getTasksByTasksType(taskType)
    }
}
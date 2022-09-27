package com.greemoid.ithelps.domain.usecases.todo

import androidx.lifecycle.LiveData
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.repository.TaskRepository
import javax.inject.Inject

class GetTasksByTaskTypeUseCase @Inject constructor(
    private val taskRepository: TaskRepository,
) {

    fun getTasksByTasksType(taskType: String): LiveData<List<TaskDB>> {
        return taskRepository.getTasksByTasksType(taskType)
    }
}
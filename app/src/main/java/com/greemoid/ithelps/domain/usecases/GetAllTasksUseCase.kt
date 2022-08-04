package com.greemoid.ithelps.domain.usecases

import com.greemoid.ithelps.domain.models.Task
import com.greemoid.ithelps.domain.repository.TaskRepository

class GetAllTasksUseCase(
    private val taskRepository: TaskRepository
) {

    fun getAllTasks(): List<Task> {
        return taskRepository.getAllTasks()
    }
}
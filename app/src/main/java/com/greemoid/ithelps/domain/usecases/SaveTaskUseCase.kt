package com.greemoid.ithelps.domain.usecases

import com.greemoid.ithelps.domain.models.Task
import com.greemoid.ithelps.domain.repository.TaskRepository

class SaveTaskUseCase(
    private val taskRepository: TaskRepository
) {

    suspend fun saveTask(task: Task) {
        taskRepository.insertTask(task)
    }
}
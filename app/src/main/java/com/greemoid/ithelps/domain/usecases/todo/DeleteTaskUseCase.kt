package com.greemoid.ithelps.domain.usecases.todo

import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.repository.TaskRepository

class DeleteTaskUseCase(
    private val taskRepository: TaskRepository,
) {

    suspend fun deleteTask(task: TaskDB) {
        taskRepository.deleteTask(task)
    }
}
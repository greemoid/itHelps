package com.greemoid.ithelps.domain.usecases.todo

import com.greemoid.ithelps.domain.models.todo.Task
import com.greemoid.ithelps.domain.repository.TaskRepository
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository,
) {

    fun getAllTasks(): List<Task> {
        return taskRepository.getAllTasks()
    }
}
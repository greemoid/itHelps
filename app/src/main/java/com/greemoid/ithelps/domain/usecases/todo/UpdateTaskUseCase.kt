package com.greemoid.ithelps.domain.usecases.todo

import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.repository.TaskRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val repository: TaskRepository,
) {

    suspend fun updateTask(taskDB: TaskDB) {
        repository.updateTask(taskDB)
    }
}
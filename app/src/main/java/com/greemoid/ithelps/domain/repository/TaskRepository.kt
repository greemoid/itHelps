package com.greemoid.ithelps.domain.repository

import androidx.lifecycle.LiveData
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.models.todo.Task

interface TaskRepository {

    fun getAllTasks(): List<Task>

    fun getTasksByTasksType(taskType: String): LiveData<List<TaskDB>>

    suspend fun insertTask(task: Task)

    suspend fun updateTask(task: TaskDB)

    suspend fun deleteTask(task: TaskDB)

}
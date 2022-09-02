package com.greemoid.ithelps.data.source

import androidx.lifecycle.LiveData
import com.greemoid.ithelps.data.db.diaryDB.TasksDao
import com.greemoid.ithelps.data.mapper.todo.TaskDBToTaskMapper
import com.greemoid.ithelps.data.mapper.todo.TaskToTaskDBMapper
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.models.todo.Task
import com.greemoid.ithelps.domain.repository.TaskRepository

class TasksCacheDataSource(
    private val tasksDao: TasksDao,
    private val dataToDomainMapper: TaskDBToTaskMapper,
    private val domainToDataMapper: TaskToTaskDBMapper,
) : TaskRepository {

    override fun getAllTasks(): List<Task> {
        val tasksList = tasksDao.getAllTasks()
        return dataToDomainMapper.map(tasksList)
    }

    override fun getTasksByTasksType(taskType: String): LiveData<List<TaskDB>> {
        return tasksDao.getTasksByTasksType(taskType)
    }

    override suspend fun insertTask(task: Task) {
        val taskDB = domainToDataMapper.map(task)
        tasksDao.insertTask(taskDB = taskDB)
    }

    override suspend fun updateTask(task: TaskDB) {
        tasksDao.updateTask(task)
    }

    override suspend fun deleteTask(task: TaskDB) {
        tasksDao.deleteTask(task)
    }


}
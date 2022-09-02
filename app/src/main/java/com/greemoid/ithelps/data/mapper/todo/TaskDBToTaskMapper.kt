package com.greemoid.ithelps.data.mapper.todo

import com.greemoid.ithelps.data.mapper.Mapper
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.models.todo.Task

class TaskDBToTaskMapper : Mapper<List<TaskDB>, List<Task>> {
    override fun map(input: List<TaskDB>): List<Task> {
        val taskList = mutableListOf<Task>()
        taskList.forEach {
            Task(
                title = it.title,
                description = it.description,
                taskType = it.taskType,
                date = it.date,
                isDone = it.isDone
            )
        }
        return taskList
    }
}
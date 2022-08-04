package com.greemoid.ithelps.data.mapper

import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.domain.models.Task

class TaskToTaskDBMapper : Mapper<Task, TaskDB> {
    override fun map(input: Task): TaskDB {
        return TaskDB(
            title = input.title,
            description = input.description,
            taskType = input.taskType,
            date = input.date,
            isDone = input.isDone
        )
    }
}
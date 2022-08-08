package com.greemoid.ithelps.data.db.diaryDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.greemoid.ithelps.data.models.TaskDB

@Dao
interface TasksDao {

    @Query("SELECT * FROM tasks_table")
    fun getAllTasks(): List<TaskDB>

    @Query("SELECT * FROM tasks_table WHERE taskType = :taskType")
    fun getTasksByTasksType(taskType: String): LiveData<List<TaskDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(taskDB: TaskDB)

    @Delete
    suspend fun deleteTask(taskDB: TaskDB)
}
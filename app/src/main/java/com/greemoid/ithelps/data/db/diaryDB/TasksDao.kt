package com.greemoid.ithelps.data.db.diaryDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greemoid.ithelps.data.models.TaskDB

@Dao
interface TasksDao {

    @Query("SELECT * FROM tasks_table")
    fun getAllTasks(): List<TaskDB>

    @Query("SELECT * FROM tasks_table WHERE taskType = :taskType")
    fun getTasksByTasksType(taskType: String): LiveData<List<TaskDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(taskDB: TaskDB)
}
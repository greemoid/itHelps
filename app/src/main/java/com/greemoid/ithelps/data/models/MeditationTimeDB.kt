package com.greemoid.ithelps.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meditation_time_table")
data class MeditationTimeDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val sessionTime: Long,
    @ColumnInfo val totalTime: Long,
    @ColumnInfo val date: String,
)

package com.greemoid.ithelps.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary_table")
data class DiaryNoteDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val description: String,
    @ColumnInfo val date: String,
)

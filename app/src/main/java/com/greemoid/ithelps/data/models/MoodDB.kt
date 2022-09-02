package com.greemoid.ithelps.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_table")
data class MoodDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val moodType: String,
    @ColumnInfo val moodDescription: String,
    @ColumnInfo val date: String,
)

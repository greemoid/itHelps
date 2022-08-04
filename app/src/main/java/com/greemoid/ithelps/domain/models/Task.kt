package com.greemoid.ithelps.domain.models

data class Task(
    val title: String,
    val description: String,
    val taskType: String,
    val date: String,
    val isDone: Boolean,
)

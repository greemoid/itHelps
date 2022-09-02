package com.greemoid.ithelps.domain.models.meditation

data class Meditation(
    val id: Int = 0,
    val sessionTime: Long,
    val totalTime: Long,
    val date: String,
)

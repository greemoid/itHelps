package com.greemoid.ithelps.presentation.instruments.breathing

import java.io.Serializable

data class BreathingTime(
    val totalTime: Int,
    val breath: Int,
    val firstDelay: Int,
    val exhalation: Int,
    val secondDelay: Int,
) : Serializable
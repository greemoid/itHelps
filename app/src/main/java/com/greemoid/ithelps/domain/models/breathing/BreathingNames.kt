package com.greemoid.ithelps.domain.models.breathing


enum class BreathingNames(
    name: String,
    val breath: Int,
    val firstDelay: Int = 0,
    val exhalation: Int,
    val secondDelay: Int = 0,
) {
    REFRESH(name = "", breath = 3, firstDelay = 2, exhalation = 4),
    DEEP_BREATH(name = "", breath = 4, firstDelay = 4, exhalation = 4, secondDelay = 4),
    WAKING_UP(name = "", breath = 2, exhalation = 2),
    RELAX(name = "", breath = 6, firstDelay = 7, exhalation = 8),
    PAINKILLER(name = "", breath = 4, firstDelay = 4, exhalation = 6),
    SOS(name = "", breath = 3, exhalation = 3),
}
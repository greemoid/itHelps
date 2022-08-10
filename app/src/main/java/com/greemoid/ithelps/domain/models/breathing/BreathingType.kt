package com.greemoid.ithelps.domain.models.breathing

import androidx.annotation.DrawableRes
import java.io.Serializable

data class BreathingType(
    @DrawableRes val drawableId: Int,
    val breathingName: String,
    val breath: Int = 0,
    val firstDelay: Int = 0,
    val exhalation: Int = 0,
    val secondDelay: Int = 0,
) : Serializable
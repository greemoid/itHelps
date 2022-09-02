package com.greemoid.ithelps.domain.models.mood

import androidx.annotation.DrawableRes
import java.io.Serializable

data class MoodType(
    val typeEnum: MoodNames,
    @DrawableRes val drawableId: Int,
    val moodName: String,
) : Serializable

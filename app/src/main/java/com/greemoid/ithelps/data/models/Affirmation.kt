package com.greemoid.ithelps.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val textAffirmation: Int,
    @DrawableRes val imageAffirmation: Int,
)

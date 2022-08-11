package com.greemoid.ithelps.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quote(
    @StringRes val textAffirmation: Int,
    @DrawableRes val imageAffirmation: Int,
)
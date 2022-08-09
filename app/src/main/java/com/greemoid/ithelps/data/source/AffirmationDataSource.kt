package com.greemoid.ithelps.data.source

import com.greemoid.ithelps.R
import com.greemoid.ithelps.data.models.Affirmation

class AffirmationDataSource {

    fun load(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation1, R.drawable.affirmation1),
            Affirmation(R.string.affirmation2, R.drawable.affirmation2),
            Affirmation(R.string.affirmation3, R.drawable.affirmation3),
            Affirmation(R.string.affirmation4, R.drawable.affirmation4),
            Affirmation(R.string.affirmation5, R.drawable.affirmation5),
            Affirmation(R.string.affirmation6, R.drawable.affirmation6),
            Affirmation(R.string.affirmation7, R.drawable.affirmation7),
            Affirmation(R.string.affirmation8, R.drawable.affirmation8),
            Affirmation(R.string.affirmation9, R.drawable.affirmation9),
            Affirmation(R.string.affirmation10, R.drawable.affirmation10),
        )
    }
}
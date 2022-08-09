package com.greemoid.ithelps.data.source

import com.greemoid.ithelps.R
import com.greemoid.ithelps.data.models.Quote

class QuotesDataSource {

    fun load(): List<Quote> {
        return listOf(
            Quote(R.string.quote1, R.drawable.affirmation1),
            Quote(R.string.quote2, R.drawable.affirmation2),
            Quote(R.string.quote3, R.drawable.affirmation3),
            Quote(R.string.quote4, R.drawable.affirmation4),
            Quote(R.string.quote5, R.drawable.affirmation5),
            Quote(R.string.quote6, R.drawable.affirmation6),
            Quote(R.string.quote7, R.drawable.affirmation7),
            Quote(R.string.quote8, R.drawable.affirmation8),
            Quote(R.string.quote9, R.drawable.affirmation9),
            Quote(R.string.quote10, R.drawable.affirmation10),
        )
    }
}
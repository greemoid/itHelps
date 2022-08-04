package com.greemoid.ithelps.data.mapper

import com.greemoid.ithelps.data.models.MoodDB
import com.greemoid.ithelps.domain.models.Mood


class MoodToMoodDBMapper : Mapper<Mood, MoodDB> {
    override fun map(input: Mood): MoodDB {
        return MoodDB(
            moodType = input.moodType,
            moodDescription = input.moodDescription,
            date = input.date
        )
    }
}
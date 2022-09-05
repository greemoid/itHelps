package com.greemoid.ithelps.data.mapper.mood

import com.greemoid.ithelps.core.data.Mapper
import com.greemoid.ithelps.data.models.MoodDB
import com.greemoid.ithelps.domain.models.mood.Mood


class MoodToMoodDBMapper : Mapper<Mood, MoodDB> {
    override fun map(input: Mood): MoodDB {
        return MoodDB(
            moodType = input.moodType,
            moodDescription = input.moodDescription,
            date = input.date
        )
    }
}
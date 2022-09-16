package com.greemoid.ithelps.data.mapper.mood

import com.greemoid.ithelps.core.data.Mapper
import com.greemoid.ithelps.data.models.MoodDB
import com.greemoid.ithelps.domain.models.mood.Mood

class MoodDBToMoodMapper : Mapper<List<MoodDB>, List<Mood>> {
    override fun map(input: List<MoodDB>): List<Mood> {
        val list = mutableListOf<Mood>()
        input.forEach {
            list.add(
                Mood(
                    it.moodType,
                    it.moodDescription,
                    it.date
                )
            )
        }
        return list
    }
}

class LastMoodDbToMoodMapper : Mapper<MoodDB, Mood> {
    override fun map(input: MoodDB): Mood {
        return Mood(
            moodType = input.moodType,
            moodDescription = input.moodDescription,
            date = input.date
        )
    }

}
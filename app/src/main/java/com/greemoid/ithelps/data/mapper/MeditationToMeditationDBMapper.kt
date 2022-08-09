package com.greemoid.ithelps.data.mapper

import com.greemoid.ithelps.data.models.MeditationTimeDB
import com.greemoid.ithelps.domain.models.meditation.Meditation

class MeditationToMeditationDBMapper: Mapper<Meditation, MeditationTimeDB> {
    override fun map(input: Meditation): MeditationTimeDB {
        return MeditationTimeDB(
            id = input.id,
            sessionTime = input.sessionTime,
            totalTime = input.totalTime,
            date = input.date
        )
    }

}
package com.greemoid.ithelps.data.mapper.meditation

import com.greemoid.ithelps.core.data.Mapper
import com.greemoid.ithelps.data.models.MeditationTimeDB
import com.greemoid.ithelps.domain.models.meditation.Meditation

class MeditationDBToMeditationMapper : Mapper<MeditationTimeDB, Meditation> {
    override fun map(input: MeditationTimeDB): Meditation {
        return Meditation(
            id = input.id,
            sessionTime = input.sessionTime,
            totalTime = input.totalTime,
            date = input.date
        )
    }
}
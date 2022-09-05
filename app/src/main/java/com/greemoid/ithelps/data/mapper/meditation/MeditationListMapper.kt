package com.greemoid.ithelps.data.mapper.meditation

import com.greemoid.ithelps.core.data.Mapper
import com.greemoid.ithelps.data.models.MeditationTimeDB
import com.greemoid.ithelps.domain.models.meditation.Meditation

class MeditationListMapper : Mapper<List<MeditationTimeDB>, List<Meditation>> {
    override fun map(input: List<MeditationTimeDB>): List<Meditation> {
        val list = mutableListOf<Meditation>()
        input.forEach {
            list.add(
                Meditation(
                    it.id,
                    it.sessionTime,
                    it.totalTime,
                    it.date
                )
            )
        }
        return list
    }
}
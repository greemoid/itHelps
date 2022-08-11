package com.greemoid.ithelps.data.mapper.meditation

import com.greemoid.ithelps.data.mapper.Mapper
import com.greemoid.ithelps.data.models.MeditationTimeDB
import com.greemoid.ithelps.domain.models.meditation.Meditation

class MeditationListMapper : Mapper<List<MeditationTimeDB>, List<Meditation>> {
    override fun map(input: List<MeditationTimeDB>): List<Meditation> {
        val list = mutableListOf<Meditation>()
        list.forEach {
            list.add(
                Meditation(
                    id = it.id,
                    sessionTime = it.sessionTime,
                    totalTime = it.totalTime,
                    date = it.date
                )
            )
        }
        return list
    }
}
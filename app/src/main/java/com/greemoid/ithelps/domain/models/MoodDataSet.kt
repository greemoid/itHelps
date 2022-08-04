package com.greemoid.ithelps.domain.models

import com.greemoid.ithelps.R

class MoodDataSet() {

    fun load() : List<MoodType> {
        return listOf(
            MoodType(MoodNames.JOY, R.drawable.joy, MoodNames.JOY.mood),
            MoodType(MoodNames.LOVE, R.drawable.love, MoodNames.LOVE.mood),
            MoodType(MoodNames.CARELESSNESS, R.drawable.carelessness, MoodNames.CARELESSNESS.mood),
            MoodType(MoodNames.INSPIRATION, R.drawable.inspiration, MoodNames.INSPIRATION.mood),
            MoodType(MoodNames.ANGER, R.drawable.anger, MoodNames.ANGER.mood),
            MoodType(MoodNames.IRRITATION, R.drawable.irritation, MoodNames.IRRITATION.mood),
            MoodType(MoodNames.DISCONTENT, R.drawable.discontent, MoodNames.DISCONTENT.mood),
            MoodType(MoodNames.INSULT, R.drawable.insult, MoodNames.INSULT.mood),
            MoodType(MoodNames.MALICE, R.drawable.malice, MoodNames.MALICE.mood),
            MoodType(MoodNames.JEALOUSY, R.drawable.jealousy, MoodNames.JEALOUSY.mood),
            MoodType(MoodNames.SORROW, R.drawable.sorrow, MoodNames.SORROW.mood),
            MoodType(MoodNames.DISAPPOINTMENT, R.drawable.disappointed, MoodNames.DISAPPOINTMENT.mood),
            MoodType(MoodNames.DESPAIR, R.drawable.despair, MoodNames.DESPAIR.mood),
            MoodType(MoodNames.UPSET, R.drawable.upset, MoodNames.UPSET.mood),
            MoodType(MoodNames.GRIEF, R.drawable.grief, MoodNames.GRIEF.mood),
            MoodType(MoodNames.FEAR, R.drawable.fear, MoodNames.FEAR.mood),
            MoodType(MoodNames.CONCERN, R.drawable.concern, MoodNames.CONCERN.mood),
            MoodType(MoodNames.ANXIETY, R.drawable.anxiety, MoodNames.ANXIETY.mood),
            MoodType(MoodNames.PANIC, R.drawable.panic, MoodNames.PANIC.mood),
            MoodType(MoodNames.FAULT, R.drawable.fault, MoodNames.FAULT.mood),
        )
    }
}
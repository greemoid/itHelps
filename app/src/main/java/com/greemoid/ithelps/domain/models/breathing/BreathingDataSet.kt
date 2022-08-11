package com.greemoid.ithelps.domain.models.breathing

import com.greemoid.ithelps.R

class BreathingDataSet {

    fun load(): List<BreathingType> {
        return listOf(
            BreathingType(R.drawable.refresh,
                BreathingNames.REFRESH.name,
                BreathingNames.REFRESH.breath,
                BreathingNames.REFRESH.firstDelay,
                BreathingNames.REFRESH.exhalation,
                BreathingNames.REFRESH.secondDelay),
            BreathingType(R.drawable.deep,
                BreathingNames.DEEP_BREATH.name,
                BreathingNames.DEEP_BREATH.breath,
                BreathingNames.DEEP_BREATH.firstDelay,
                BreathingNames.DEEP_BREATH.exhalation,
                BreathingNames.DEEP_BREATH.secondDelay),
            BreathingType(R.drawable.alarm,
                BreathingNames.WAKING_UP.name,
                BreathingNames.WAKING_UP.breath,
                BreathingNames.WAKING_UP.firstDelay,
                BreathingNames.WAKING_UP.exhalation,
                BreathingNames.WAKING_UP.secondDelay),
            BreathingType(R.drawable.relax,
                BreathingNames.RELAX.name,
                BreathingNames.RELAX.breath,
                BreathingNames.RELAX.firstDelay,
                BreathingNames.RELAX.exhalation,
                BreathingNames.RELAX.secondDelay),
            BreathingType(R.drawable.pain,
                BreathingNames.PAINKILLER.name,
                BreathingNames.PAINKILLER.breath,
                BreathingNames.PAINKILLER.firstDelay,
                BreathingNames.PAINKILLER.exhalation,
                BreathingNames.PAINKILLER.secondDelay),
            BreathingType(R.drawable.sos,
                BreathingNames.SOS.name,
                BreathingNames.SOS.breath,
                BreathingNames.SOS.firstDelay,
                BreathingNames.SOS.exhalation,
                BreathingNames.SOS.secondDelay),
        )
    }
}
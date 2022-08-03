package com.greemoid.ithelps.di

import com.greemoid.ithelps.domain.usecases.SaveDiaryNoteUseCase
import com.greemoid.ithelps.domain.usecases.SaveMoodUseCase
import org.koin.dsl.module

val domainModule = module {

    single {
        SaveDiaryNoteUseCase(
            diaryRepository = get()
        )
    }

    single {
        SaveMoodUseCase(
            moodRepository = get()
        )
    }
}
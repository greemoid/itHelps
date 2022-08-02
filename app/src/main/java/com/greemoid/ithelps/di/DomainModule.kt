package com.greemoid.ithelps.di

import com.greemoid.ithelps.domain.usecases.SaveDiaryNoteUseCase
import org.koin.dsl.module

val domainModule = module {

    single {
        SaveDiaryNoteUseCase(
            diaryRepository = get()
        )
    }
}
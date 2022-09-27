package com.greemoid.ithelps.di

import android.content.Context
import com.greemoid.ithelps.core.presentation.BaseVibratorManager
import com.greemoid.ithelps.presentation.core.Date
import com.greemoid.ithelps.presentation.core.VibratorManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    @Singleton
    fun provideDate(): Date = Date()

    @Provides
    @Singleton
    fun provideVibratorManager(@ApplicationContext context: Context): BaseVibratorManager =
        VibratorManager(context)

}

package com.araikovich.yandesx_sdk.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class CoroutineModule {

    @Provides
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO
}
package com.araikovich.yandesx_sdk.di

import android.content.Context
import com.araikovich.yandesx_sdk.ui.base.AppViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ViewModelModule::class, CoroutineModule::class, DBModule::class, NetworkModule::class, MapperModule::class, ApiModule::class])
@Singleton
interface AppComponent {

    val factory: AppViewModelFactory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
package com.araikovich.sdk_showcase.di

import com.araikovich.sdk_showcase.domain.YandexPlusInfoManager
import dagger.Component

@Component
internal interface ModuleComponent {

    fun inject(manager: YandexPlusInfoManager)
}
package com.araikovich.sdk_showcase

import android.os.SystemClock
import com.araikovich.sdk_showcase.di.ModuleComponent

object YandexPlusComponent {

    internal var moduleComponent: ModuleComponent? = null
        private set

    internal var externalDependencies: ExternalDependencies? = null
        private set

    internal val contract
        get() = externalDependencies?.contract

    internal var initTime: Long = 0
        private set

    fun init(dependencies: ExternalDependencies) {
        externalDependencies = dependencies
        moduleComponent = DaggerModuleComponent.create()
        initTime = SystemClock.elapsedRealtime()
    }
}
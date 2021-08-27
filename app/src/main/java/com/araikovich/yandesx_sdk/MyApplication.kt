package com.araikovich.yandesx_sdk

import android.app.Application
import com.araikovich.sdk_showcase.ExternalDependencies
import com.araikovich.sdk_showcase.YandexPlusComponent
import com.araikovich.sdk_showcase.YandexPlusContract
import com.araikovich.sdk_showcase.ui.plus.YandexPlusUserInfoModel
import com.araikovich.yandesx_sdk.di.AppComponent
import com.araikovich.yandesx_sdk.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
        YandexPlusComponent.init(ExternalDependencies(
            object : YandexPlusContract {
                override val userId: String = "3456"

                override fun openYandexBonusProgram(data: YandexPlusUserInfoModel) {

                }
            }
        ))
    }
}
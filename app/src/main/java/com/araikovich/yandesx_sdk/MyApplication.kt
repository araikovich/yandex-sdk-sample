package com.araikovich.yandesx_sdk

import android.app.Application
import com.araikovich.sdk_showcase.ExternalDependencies
import com.araikovich.sdk_showcase.YandexPlusComponent
import com.araikovich.sdk_showcase.YandexPlusContract
import com.araikovich.sdk_showcase.ui.plus.YandexPlusUserInfoModel

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        YandexPlusComponent.init(ExternalDependencies(
            object : YandexPlusContract {
                override val userId: String = "3456"

                override fun openYandexBonusProgram(data: YandexPlusUserInfoModel) {

                }
            }
        ))
    }
}
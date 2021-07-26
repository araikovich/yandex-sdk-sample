package com.araikovich.sdk_showcase

import com.araikovich.sdk_showcase.ui.plus.YandexPlusUserInfoModel

interface YandexPlusContract {

    val userId: String

    fun openYandexBonusProgram(data: YandexPlusUserInfoModel)
}
package com.araikovich.sdk_showcase.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class UserInfoDataSource @Inject constructor() {

    suspend fun getYandexPlusInfoModel(): YandexPlusUserInfoResponse {
        return withContext(Dispatchers.IO) {
            delay(3000)
            YandexPlusUserInfoResponse("3425435", 354, true)
        }
    }
}
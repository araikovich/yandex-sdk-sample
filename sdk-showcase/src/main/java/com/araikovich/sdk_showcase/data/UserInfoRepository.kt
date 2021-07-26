package com.araikovich.sdk_showcase.data

import com.araikovich.sdk_showcase.ui.plus.YandexPlusUserInfoModel
import javax.inject.Inject

internal class UserInfoRepository @Inject constructor(private val dataSource: UserInfoDataSource) {

    suspend fun getYandexPlusUserInfo(): YandexPlusUserInfoModel {
        return mapResponseToModel(dataSource.getYandexPlusInfoModel())
    }

    private fun mapResponseToModel(response: YandexPlusUserInfoResponse) = YandexPlusUserInfoModel(
        response.userId,
        response.bonusCount.toString(),
        response.isSaleAvailable,
        "fsdf"
    )
}
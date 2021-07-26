package com.araikovich.sdk_showcase.domain

import com.araikovich.sdk_showcase.data.UserInfoRepository
import com.araikovich.sdk_showcase.ui.plus.YandexPlusUserInfoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class GetUserInfoUseCase @Inject constructor(private val repository: UserInfoRepository) {

    suspend fun invoke(userId: String): YandexPlusUserInfoModel {
        val model = repository.getYandexPlusUserInfo()
        return doSomeLongLogicWithModel(model)
    }

    private suspend fun doSomeLongLogicWithModel(model: YandexPlusUserInfoModel): YandexPlusUserInfoModel {
        return withContext(Dispatchers.Default) {
            delay(3000) //Some difficult long login
            model
        }
    }
}
package com.araikovich.sdk_showcase.data

internal data class YandexPlusUserInfoResponse(
    val userId: String,
    val bonusCount: Long,
    val isSaleAvailable: Boolean
)
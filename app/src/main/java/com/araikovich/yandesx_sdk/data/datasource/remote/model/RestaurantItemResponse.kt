package com.araikovich.yandesx_sdk.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class GetRestaurantsResponse(
    @SerializedName("results") val results: List<RestaurantItemResponse>? = null
)

data class RestaurantItemResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val name: String? = null,
    @SerializedName("image") val imageSrc: String? = null,
    @SerializedName("dishTypes") val categories: List<String>? = null,
    @SerializedName("readyInMinutes") val timeForDelivery: Int? = null,
    @SerializedName("pricePerServing") val deliveryPrice: Double? = null
)
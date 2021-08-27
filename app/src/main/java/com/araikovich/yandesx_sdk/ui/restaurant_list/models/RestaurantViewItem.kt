package com.araikovich.yandesx_sdk.ui.restaurant_list.models

import com.araikovich.yandesx_sdk.data.base.Price

data class RestaurantViewItem(
    val id: Int,
    val name: String,
    val imageSrc: String,
    val categories: List<String>,
    val timeForDelivery: Int,
    val deliveryPrice: Double
)
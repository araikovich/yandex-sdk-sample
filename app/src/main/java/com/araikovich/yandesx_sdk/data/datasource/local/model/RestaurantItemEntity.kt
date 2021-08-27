package com.araikovich.yandesx_sdk.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RestaurantItemEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val imageSrc: String,
    val categories: List<String>,
    val timeForDelivery: Int,
    val deliveryPrice: Double
)
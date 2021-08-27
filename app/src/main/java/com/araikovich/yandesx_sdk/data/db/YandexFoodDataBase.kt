package com.araikovich.yandesx_sdk.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.araikovich.yandesx_sdk.data.datasource.local.model.RestaurantItemEntity
import com.araikovich.yandesx_sdk.data.db.converters.RestaurantTypeConverter
import com.araikovich.yandesx_sdk.data.db.dao.RestaurantDao

@Database(entities = [RestaurantItemEntity::class], version = 1)
@TypeConverters(RestaurantTypeConverter::class)
abstract class YandexFoodDataBase: RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}
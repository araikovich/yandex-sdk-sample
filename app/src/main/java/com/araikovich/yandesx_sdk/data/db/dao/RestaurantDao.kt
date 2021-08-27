package com.araikovich.yandesx_sdk.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.araikovich.yandesx_sdk.data.datasource.local.model.RestaurantItemEntity

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM RestaurantItemEntity")
    fun getAll(): List<RestaurantItemEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(restaurants: List<RestaurantItemEntity>)
}
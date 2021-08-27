package com.araikovich.yandesx_sdk.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.araikovich.yandesx_sdk.data.db.YandexFoodDataBase
import com.araikovich.yandesx_sdk.data.db.converters.RestaurantTypeConverter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Provides
    @Singleton
    fun provideRestaurantsDataBase(context: Context) =
        Room.databaseBuilder(context, YandexFoodDataBase::class.java, "yandex_database").build()

    @Provides
    @Singleton
    fun provideRestaurantsDao(database: YandexFoodDataBase) = database.restaurantDao()
}
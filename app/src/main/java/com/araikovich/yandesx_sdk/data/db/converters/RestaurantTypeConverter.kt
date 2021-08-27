package com.araikovich.yandesx_sdk.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RestaurantTypeConverter {

    @TypeConverter
    fun fromListCategoriesToString(categories: List<String>): String {
        return Gson().toJson(categories)
    }

    @TypeConverter
    fun fromStringToCategoriesList(string: String): List<String> {
        return Gson().fromJson(string) as List<String>
    }

    inline fun <reified T> Gson.fromJson(json: String): T =
        fromJson(json, object : TypeToken<T>() {}.type)
}
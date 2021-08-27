package com.araikovich.yandesx_sdk.data.datasource.local

import com.araikovich.yandesx_sdk.data.base.ResultWrapper
import com.araikovich.yandesx_sdk.data.datasource.local.model.RestaurantItemEntity
import com.araikovich.yandesx_sdk.data.db.dao.RestaurantDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestaurantLocalDataSource @Inject constructor(
    private val dao: RestaurantDao,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend fun getAllRestaurants(): ResultWrapper<List<RestaurantItemEntity>> {
        return withContext(coroutineDispatcher) {
            dao.getAll()?.let {
                ResultWrapper.Success(it)
            } ?: ResultWrapper.Error.UnknownError("data is emty")
        }
    }

    suspend fun saveRestaurants(restaurants: List<RestaurantItemEntity>) {
        withContext(coroutineDispatcher) {
            dao.insertAll(restaurants)
        }
    }
}
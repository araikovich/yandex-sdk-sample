package com.araikovich.yandesx_sdk.di

import com.araikovich.yandesx_sdk.data.api.RestaurantsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun provideRestaurantsApi(retrofit: Retrofit): RestaurantsApi = retrofit.create(RestaurantsApi::class.java)
}
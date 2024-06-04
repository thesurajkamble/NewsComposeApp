package com.surajkamble.newsapp_machine_coding.data.di

import com.surajkamble.newsapp_machine_coding.common.Constants
import com.surajkamble.newsapp_machine_coding.data.remote.data_source.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
   fun  provideAPi(retrofit:Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)
}
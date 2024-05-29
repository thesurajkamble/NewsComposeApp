package com.surajkamble.newsapp_machine_coding.data.di

import androidx.compose.ui.unit.Constraints
import com.surajkamble.newsapp_machine_coding.base.Constants
import com.surajkamble.newsapp_machine_coding.data.remote.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
   fun  provideAPi(retrofit:Retrofit): Service =
        retrofit.create(Service::class.java)
}
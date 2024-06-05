package com.surajkamble.newsapp_machine_coding.data.remote.data_source

import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getAllArticles(
        @Query("q") query: String,
        @Query("from") fromDate: String,
        @Query("apiKey") apiKey: String
    ): Response<AllArticleDto?>

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<TopHeadLineDto?>
}
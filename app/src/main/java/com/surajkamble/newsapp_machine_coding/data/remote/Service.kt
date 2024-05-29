package com.surajkamble.newsapp_machine_coding.data.remote

import com.surajkamble.newsapp_machine_coding.base.Result
import com.surajkamble.newsapp_machine_coding.data.remote.model.AllArticleResponse
import com.surajkamble.newsapp_machine_coding.data.remote.model.TopHeadLineResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("/v2/everything")
    suspend fun getAllArticles(
        @Query("q") query: String,
        @Query("from") fromDate: String,
        @Query("apiKey") apiKey: String
    ): Result<AllArticleResponse>

    @GET("/v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Result<TopHeadLineResponse>
}
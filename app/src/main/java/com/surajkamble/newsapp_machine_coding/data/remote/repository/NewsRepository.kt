package com.surajkamble.newsapp_machine_coding.data.remote.repository

import com.surajkamble.newsapp_machine_coding.common.Result
import com.surajkamble.newsapp_machine_coding.data.remote.data_source.NewsApi
import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi
) : BaseRepository(Dispatchers.Main) {

    suspend fun getAllArticles(
        apiKey: String, fromDate: String, queryString: String
    ): Result<AllArticleDto> {
        return safeApiCall {
            newsApi.getAllArticles(
                apiKey = apiKey, fromDate = fromDate, query = queryString
            )
        }
    }

    suspend fun getTopHeadLines(country: String, apiKey: String):
            Result<TopHeadLineDto> {
        return safeApiCall {
            newsApi.getTopHeadLines(
                country, apiKey
            )
        }
    }
}
package com.surajkamble.newsapp_machine_coding.data.remote.repository

import com.surajkamble.newsapp_machine_coding.common.Repository.BaseRepository
import com.surajkamble.newsapp_machine_coding.data.remote.data_source.NewsApi
import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface NewsReposity {

}

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi
) : BaseRepository(Dispatchers.Main) {

    suspend fun getAllArticles(
        apiKey: String, fromDate: String, queryString: String
    ): AllArticleDto? {
        safeApiCall {
            newsApi.getAllArticles(
                apiKey = apiKey, fromDate = fromDate, query = queryString
            )
        }.let { result ->
            return result.data
        }
    }

    suspend fun getTopHeadLines(
        country: String,
        apiKey: String
    ): TopHeadLineDto? {
        safeApiCall {
            newsApi.getTopHeadLines(
                country, apiKey
            )
        }.let { result ->
            return result.data
        }
    }
}
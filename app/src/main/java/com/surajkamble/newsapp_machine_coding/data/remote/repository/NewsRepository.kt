package com.surajkamble.newsapp_machine_coding.data.remote.repository

import com.surajkamble.newsapp_machine_coding.base.Result
import com.surajkamble.newsapp_machine_coding.data.remote.Service
import com.surajkamble.newsapp_machine_coding.data.remote.model.AllArticleResponse
import com.surajkamble.newsapp_machine_coding.data.remote.model.TopHeadLineResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val service: Service
) : BaseRepository(Dispatchers.Main) {

    suspend fun getAllArticles(
        apiKey: String, fromDate: String, queryString: String
    ): Result<AllArticleResponse> {
        return safeApiCall {
            service.getAllArticles(
                apiKey = apiKey, fromDate = fromDate, query = queryString
            )
        }
    }

    suspend fun getTopHeadLines(country: String, apiKey: String):
            Result<TopHeadLineResponse> {
        return safeApiCall {
            service.getTopHeadLines(
                country, apiKey
            )
        }
    }
}
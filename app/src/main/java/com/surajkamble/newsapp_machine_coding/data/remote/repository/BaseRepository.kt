package com.surajkamble.newsapp_machine_coding.data.remote.repository

import com.surajkamble.newsapp_machine_coding.base.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

open class BaseRepository(private val dispatcher: CoroutineDispatcher) {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return withContext(dispatcher) {
            try {
                val response = apiCall()
                Result.Success(response)
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
    }
}
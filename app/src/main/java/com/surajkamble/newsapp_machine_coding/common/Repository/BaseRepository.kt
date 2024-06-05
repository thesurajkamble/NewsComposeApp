package com.surajkamble.newsapp_machine_coding.common.Repository

import android.util.Log
import com.surajkamble.newsapp_machine_coding.common.CustomException.HTTP_EXCEPTION
import com.surajkamble.newsapp_machine_coding.common.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

const val TAG = "NETWORK_TAG"

open class BaseRepository(private val dispatcher: CoroutineDispatcher) {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T?>): Result<T?> {
        return withContext(dispatcher) {
            try {
                Result.Loading("Loading")
                val response = apiCall()
                if (response.isSuccessful) {
                    Log.d(TAG, "Http Success: ${response.body()}")
                    Result.Success(response.body())
                } else {
                    Log.d(TAG, "Http Error: ${response.code()}")
                    Result.Error(Exception(HTTP_EXCEPTION))
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
    }
}
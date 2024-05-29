package com.surajkamble.newsapp_machine_coding.base

sealed class Result<T>(
    val data: T? = null,
    val message: Exception? = null
) {
    class Success<T>(data: T?) : Result<T>(data)
    class Error<T>(message: Exception?, data: T? = null) : Result<T>(data, message)
    class Loading<T> : Result<T>()
}

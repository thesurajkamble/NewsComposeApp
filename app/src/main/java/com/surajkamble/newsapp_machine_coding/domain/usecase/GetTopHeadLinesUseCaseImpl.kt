package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.base.Result
import com.surajkamble.newsapp_machine_coding.data.remote.model.TopHeadLineResponse
import com.surajkamble.newsapp_machine_coding.data.remote.repository.NewsRepository

class GetTopHeadLinesUseCaseImpl(
    private val newsRepository: NewsRepository
) : GetTopHeadLinesUseCase {

    data class Input(
        val country: String = "us",
        val apikey: String = "d6d0b971e5674e91a71d3c5bf144084c"
    )

    override suspend fun execute(input: Input): Result<TopHeadLineResponse> {
        return newsRepository.getTopHeadLines(
            country = input.country,
            apiKey = input.country
        )
    }
}
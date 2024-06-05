package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.common.Result
import com.surajkamble.newsapp_machine_coding.common.toTopHeadlinesDomainEntity
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto
import com.surajkamble.newsapp_machine_coding.data.remote.repository.NewsRepository
import com.surajkamble.newsapp_machine_coding.domain.entity.TopHeadLinesEntity
import javax.inject.Inject

class GetTopHeadLinesUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : GetTopHeadLinesUseCase {

    data class Input(
        val country: String = "us",
        val apikey: String = "d6d0b971e5674e91a71d3c5bf144084c"
    )

    override suspend fun execute(input: Input): TopHeadLinesEntity? {
        return newsRepository.getTopHeadLines(
            country = input.country,
            apiKey = input.country
        )?.toTopHeadlinesDomainEntity()
    }
}
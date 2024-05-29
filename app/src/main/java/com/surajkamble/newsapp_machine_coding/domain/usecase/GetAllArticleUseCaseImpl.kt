package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.data.remote.model.AllArticleResponse
import com.surajkamble.newsapp_machine_coding.data.remote.repository.NewsRepository

class GetAllArticleUseCaseImpl constructor(
    private val repository: NewsRepository
) : GetAllArticleUseCase {
    data class Input(
        val query: String,
        val fromDate: String,
        val apiKey: String
    )

    override suspend fun execute(input: Input): Result<AllArticleResponse> {
        return repository.getAllArticles(
            input.apiKey,
            input.fromDate,
            input.query
        )
    }
}
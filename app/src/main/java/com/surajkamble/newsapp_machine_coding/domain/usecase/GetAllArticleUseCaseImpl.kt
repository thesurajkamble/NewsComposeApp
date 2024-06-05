package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.common.Result
import com.surajkamble.newsapp_machine_coding.common.toArticleDomainEntity
import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.data.remote.repository.NewsRepository
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity
import javax.inject.Inject

class GetAllArticleUseCaseImpl @Inject constructor(
    private val repository: NewsRepository
) : GetAllArticleUseCase {
    data class Input(
        val query: String,
        val fromDate: String,
        val apiKey: String
    )

    override suspend fun execute(input: Input): AllArticleEntity? {
        return repository.getAllArticles(
            input.apiKey,
            input.fromDate,
            input.query
        )?.toArticleDomainEntity()
    }
}
package com.surajkamble.newsapp_machine_coding.domain.mapper

import com.surajkamble.newsapp_machine_coding.common.mapper.Mapper
import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity
import javax.inject.Inject

class AllArticleDtoToModelMapper @Inject constructor(

) : Mapper<AllArticleDto, AllArticleEntity> {
    override suspend fun mapFrom(from: AllArticleDto): AllArticleEntity {
        return AllArticleEntity(
            article = from.articles?.let {

            }
        )
    }
}
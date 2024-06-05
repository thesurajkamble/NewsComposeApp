package com.surajkamble.newsapp_machine_coding.common

import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity
import com.surajkamble.newsapp_machine_coding.domain.entity.TopHeadLinesEntity


fun AllArticleDto.Article.toArticleDomainEntity(): AllArticleEntity.Article {
    return AllArticleEntity.Article(
        author = this.author,
        content = this.content,
        description = this.description,
        title = this.title,
        url = this.url,
        imageUrl = this.urlToImage
    )
}


fun AllArticleDto.toArticleDomainEntity(): AllArticleEntity? {
    return this.articles.map { it?.toArticleDomainEntity()
    }.orEmpty().let {
        AllArticleEntity(
            article = it,
            status = this.status
        )
    }
}

fun TopHeadLineDto.TopHeadLinesArticle.toTopHeadlinesDomainEntity(): TopHeadLinesEntity.HeadLinesArticle {
    return TopHeadLinesEntity.HeadLinesArticle(
        author = this.author,
        content = this.content,
        description = this.description,
        title = this.title,
        url = this.url,
        imageUrl = this.urlToImage
    )
}

fun TopHeadLineDto.toTopHeadlinesDomainEntity(): TopHeadLinesEntity? {
    return this.articles.map {
        it?.toTopHeadlinesDomainEntity()
    }.orEmpty().let {
        TopHeadLinesEntity(
            articles = it
        )
    }
}
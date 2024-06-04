package com.surajkamble.newsapp_machine_coding.domain.entity

data class AllArticleEntity(
    val article: List<Article>,
    val status: String,
) {
    data class Article(
        val author: String,
        val content: String,
        val description: String,
        val title: String,
        val url: String,
        val imageUrl: String
    )
}

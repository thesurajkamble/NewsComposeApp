package com.surajkamble.newsapp_machine_coding.domain.entity

data class TopHeadLinesEntity(
    val articles: List<HeadLinesArticle?>
) {
    data class HeadLinesArticle(
        val author: String?,
        val content: String?,
        val description: String?,
        val title: String?,
        val url: String?,
        val imageUrl: String?
    )
}

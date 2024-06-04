package com.surajkamble.newsapp_machine_coding.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AllArticleDto(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
){
    data class Article(
        @SerializedName("author")
        val author: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("publishedAt")
        val publishedAt: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("urlToImage")
        val urlToImage: String
    )
}
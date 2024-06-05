package com.surajkamble.newsapp_machine_coding.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity
import com.surajkamble.newsapp_machine_coding.domain.entity.TopHeadLinesEntity
import com.surajkamble.newsapp_machine_coding.presentation.viewmodels.UIState

@Composable
fun NewsScreen(
    article: AllArticleEntity,
    headlines: TopHeadLinesEntity
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(headlines.articles) { headlines ->
                    headlines?.let { TopHeadLinesCard(headlines) }
                }
            }
        }
        items(article.article) { article ->
            article?.let { NewsCard(article = article) }
        }
    }
}
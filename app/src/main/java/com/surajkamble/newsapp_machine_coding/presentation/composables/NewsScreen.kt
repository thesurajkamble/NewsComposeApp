package com.surajkamble.newsapp_machine_coding.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity
import com.surajkamble.newsapp_machine_coding.domain.entity.TopHeadLinesEntity

@Composable
fun NewsScreen(
    article: AllArticleEntity,
) {
//        TopicsRow()
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(article.article) { article ->
            article?.let { NewsCard(article = article) }
        }
    }

}
package com.surajkamble.newsapp_machine_coding.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopicsRow(
    onTopicSelected: (String) -> Unit,
    topics: List<String>
) {
    var selectedTopic by remember { mutableStateOf("All") }

    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 8.dp, bottom = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(topics) { topic ->
            Box(
                modifier = Modifier
                    .background(
                        color = if (selectedTopic == topic) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .clickable {
                        selectedTopic = topic
                        onTopicSelected(topic)
                    }
                    .padding(horizontal = 16.dp, vertical = 6.dp),
            ) {
                Text(
                    text = topic,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }
    }
}
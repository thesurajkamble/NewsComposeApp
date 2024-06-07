package com.surajkamble.newsapp_machine_coding

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import com.surajkamble.newsapp_machine_coding.presentation.viewmodels.NewsViewModel
import com.surajkamble.newsapp_machine_coding.presentation.theme.NewsApp_machine_codingTheme
import dagger.hilt.android.AndroidEntryPoint
import com.surajkamble.newsapp_machine_coding.presentation.composables.Loader
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity
import com.surajkamble.newsapp_machine_coding.domain.entity.TopHeadLinesEntity
import com.surajkamble.newsapp_machine_coding.presentation.composables.NewsCard
import com.surajkamble.newsapp_machine_coding.presentation.composables.NewsScreen
import com.surajkamble.newsapp_machine_coding.presentation.composables.TopHeadLinesCard
import com.surajkamble.newsapp_machine_coding.presentation.composables.TopicsRow
import com.surajkamble.newsapp_machine_coding.presentation.viewmodels.UIState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val newsViewModel: NewsViewModel by viewModels()

    val topics = listOf(
        "All",
        "Politics",
        "Business",
        "Sports",
        "Technology",
        "Health",
        "AI",
        "Climate Change",
        "Loksabha Elections 2024"
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp_machine_codingTheme {
                val context = LocalContext.current
                val articles by newsViewModel.articles.collectAsState()
                val headlines by newsViewModel.headlines.collectAsState()

                val scrollBehavior =
                    TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            ),
                            title = {
                                Text(
                                    text = "News App",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "menu"
                                    )
                                }
                            },
                            scrollBehavior = scrollBehavior
                        )
                    }

                ) { innnerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innnerPadding)
                    ) {
                        TopicsRow(topics = topics, onTopicSelected = { topic ->
                            newsViewModel.getArticles(
                                query = topic
                            )
                        })

                        when (articles) {
                            is UIState.Loading -> {
                                Loader()
                            }

                            is UIState.Success -> {
                                NewsScreen(
                                    (articles as UIState.Success<AllArticleEntity>).data
                                )
                            }

                            is UIState.Error -> {
                                Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            else -> Unit
                        }
                    }
                }

            }
        }
    }
}
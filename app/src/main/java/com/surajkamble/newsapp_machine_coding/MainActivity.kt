package com.surajkamble.newsapp_machine_coding

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.surajkamble.newsapp_machine_coding.presentation.composables.NewsCard
import com.surajkamble.newsapp_machine_coding.presentation.viewmodels.NewsViewModel
import com.surajkamble.newsapp_machine_coding.presentation.theme.NewsApp_machine_codingTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.surajkamble.newsapp_machine_coding.presentation.composables.TopAppBar
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val newsViewModel: NewsViewModel by viewModels()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp_machine_codingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopAppBar()
                    CoroutineScope(Dispatchers.Main).launch{
                        repeatOnLifecycle(Lifecycle.State.RESUMED){
                            Log.d("api", newsViewModel.articles.value.toString())

                        }
                    }

                }
            }
        }
    }
}
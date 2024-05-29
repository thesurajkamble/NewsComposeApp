package com.surajkamble.newsapp_machine_coding.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surajkamble.newsapp_machine_coding.data.remote.model.AllArticleResponse
import com.surajkamble.newsapp_machine_coding.data.remote.model.TopHeadLineResponse
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetAllArticleUseCase
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetAllArticleUseCaseImpl
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetTopHeadLinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getAllArticleUseCase: GetAllArticleUseCase,
    private val getTopHeadLinesUseCase: GetTopHeadLinesUseCase
) : ViewModel() {
    private val _articles = MutableLiveData<Result<AllArticleResponse>>()
    val articles: LiveData<Result<AllArticleResponse>> get() = _articles

    private val _headlines = MutableLiveData<Result<TopHeadLineResponse>>()
    val headlines: LiveData<Result<TopHeadLineResponse>> get() = _headlines

    data class Input(
        val query: String = "tesla",
        val fromDate: String = "2024-04-29",
        val apiKey: String = "d6d0b971e5674e91a71d3c5bf144084c"
    )

    fun getArticles(input: Input) {
        viewModelScope.launch {
            getAllArticleUseCase.execute(
                GetAllArticleUseCaseImpl.Input(
                    query = input.query,
                    fromDate = input.fromDate,
                    apiKey = input.apiKey
                )
            )
        }
    }
}
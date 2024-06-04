package com.surajkamble.newsapp_machine_coding.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto
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
    private val _articles = MutableLiveData<AllArticleDto?>()
    val articles: MutableLiveData<AllArticleDto?> get() = _articles

    private val _headlines = MutableLiveData<TopHeadLineDto>()
    val headlines: LiveData<TopHeadLineDto> get() = _headlines

    init {
        getArticles(Input())
    }

    data class Input(
        val query: String = "tesla",
        val fromDate: String = "2024-05-28",
        val apiKey: String = "d6d0b971e5674e91a71d3c5bf144084c"
    )

    private fun getArticles(input: Input) {
        viewModelScope.launch {
           val result =  getAllArticleUseCase.execute(
                GetAllArticleUseCaseImpl.Input(
                    query = input.query,
                    fromDate = input.fromDate,
                    apiKey = input.apiKey
                )
            )
            _articles.value = result.data
        }
    }
}
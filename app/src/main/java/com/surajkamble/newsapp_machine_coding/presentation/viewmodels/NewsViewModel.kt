package com.surajkamble.newsapp_machine_coding.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity
import com.surajkamble.newsapp_machine_coding.domain.entity.TopHeadLinesEntity
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetAllArticleUseCase
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetAllArticleUseCaseImpl
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetTopHeadLinesUseCase
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetTopHeadLinesUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getAllArticleUseCase: GetAllArticleUseCase,
    private val getTopHeadLinesUseCase: GetTopHeadLinesUseCase
) : ViewModel() {
    private val _articles = MutableStateFlow<UIState<AllArticleEntity>?>(UIState.Loading())
    val articles: StateFlow<UIState<AllArticleEntity>?> get() = _articles.asStateFlow()

    private val _headlines = MutableStateFlow<UIState<TopHeadLinesEntity>?>(UIState.Loading())
    val headlines: StateFlow<UIState<TopHeadLinesEntity>?> get() = _headlines.asStateFlow()


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
            _articles.emit(UIState.Loading())
            val result = getAllArticleUseCase.execute(
                GetAllArticleUseCaseImpl.Input(
                    query = input.query,
                    fromDate = input.fromDate,
                    apiKey = input.apiKey
                )
            )
            if (result != null) {
                _articles.emit(UIState.Success(result))
            } else {
                _articles.emit(UIState.Error(Exception("Something went wrong")))
            }
        }
    }

    private fun getHeadlines() {
        viewModelScope.launch {
            _headlines.emit(UIState.Loading())
            val result = getTopHeadLinesUseCase.execute(
                GetTopHeadLinesUseCaseImpl.Input(
                    country = "us",
                    apikey = "d6d0b971e5674e91a71d3c5bf144084c"
                )
            )
            if (result != null) {
                _headlines.emit(UIState.Success(result))
            } else {
                _headlines.emit(UIState.Error(Exception("Something went wrong")))
            }
        }
    }
}

sealed class UIState<T> {
    class Loading<T> : UIState<T>()

    class Success<T>(val data: T) : UIState<T>()

    class Error<T>(val error: Throwable) : UIState<T>()
}
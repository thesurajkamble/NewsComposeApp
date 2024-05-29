package com.surajkamble.newsapp_machine_coding.domain.di

import com.surajkamble.newsapp_machine_coding.domain.usecase.GetAllArticleUseCase
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetAllArticleUseCaseImpl
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetTopHeadLinesUseCase
import com.surajkamble.newsapp_machine_coding.domain.usecase.GetTopHeadLinesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {
    @Binds
    abstract fun bindGetAllTopHeadLinesUseCase(
        getTopHeadLinesUseCase: GetTopHeadLinesUseCaseImpl
    ): GetTopHeadLinesUseCase

    @Binds
    abstract fun bindGetAllArticleUseCase(
        getAllArticleUseCase: GetAllArticleUseCaseImpl
    ): GetAllArticleUseCase
}
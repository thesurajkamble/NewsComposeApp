package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.data.remote.model.AllArticleResponse

interface GetAllArticleUseCase :
    SuspendingUseCase<GetAllArticleUseCaseImpl.Input, Result<AllArticleResponse>>
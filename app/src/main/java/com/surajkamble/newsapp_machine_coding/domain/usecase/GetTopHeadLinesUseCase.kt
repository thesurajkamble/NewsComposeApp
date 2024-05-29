package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.base.Result
import com.surajkamble.newsapp_machine_coding.data.remote.model.TopHeadLineResponse

interface GetTopHeadLinesUseCase :
    SuspendingUseCase<GetTopHeadLinesUseCaseImpl.Input, Result<TopHeadLineResponse>>
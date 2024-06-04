package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.common.Result
import com.surajkamble.newsapp_machine_coding.data.remote.dto.TopHeadLineDto

interface GetTopHeadLinesUseCase :
    SuspendingUseCase<GetTopHeadLinesUseCaseImpl.Input, Result<TopHeadLineDto>>
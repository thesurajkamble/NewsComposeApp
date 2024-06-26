package com.surajkamble.newsapp_machine_coding.domain.usecase

import com.surajkamble.newsapp_machine_coding.common.Result
import com.surajkamble.newsapp_machine_coding.data.remote.dto.AllArticleDto
import com.surajkamble.newsapp_machine_coding.domain.entity.AllArticleEntity

interface GetAllArticleUseCase :
    SuspendingUseCase<GetAllArticleUseCaseImpl.Input, AllArticleEntity?>
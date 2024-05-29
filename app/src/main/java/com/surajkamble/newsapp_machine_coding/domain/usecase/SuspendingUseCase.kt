package com.surajkamble.newsapp_machine_coding.domain.usecase

interface SuspendingUseCase <in Input, out Output>{
    suspend fun execute(input: Input):Output
}
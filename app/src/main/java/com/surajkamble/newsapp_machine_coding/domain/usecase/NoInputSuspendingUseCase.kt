package com.surajkamble.newsapp_machine_coding.domain.usecase

interface NoInputSuspendingUseCase<out Output> : SuspendingUseCase<Unit, Output> {
    override suspend fun execute(input: Unit) = execute()

    suspend fun execute(): Output
}
package com.surajkamble.newsapp_machine_coding.common.mapper

interface Mapper<in I, out O> {
    suspend fun mapFrom(from: I): O
}
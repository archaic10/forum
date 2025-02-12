package br.com.vitor.forum.model

import java.time.LocalDateTime

data class Response (
    val id: Long,
    val message: String,
    val dataCreated: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution:Boolean
)

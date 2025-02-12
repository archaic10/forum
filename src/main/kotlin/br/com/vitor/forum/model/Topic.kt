package br.com.vitor.forum.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    val curse: Curse,
    val author: User,
    val status:StatusTopic = StatusTopic.NO_ANSWERED,
    val response: List<Response> = ArrayList()
)
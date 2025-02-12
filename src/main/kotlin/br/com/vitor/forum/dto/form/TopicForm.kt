package br.com.vitor.forum.dto.form

data class TopicForm (
    val title: String,
    val message: String,
    val idCurse: Long,
    val idAuthor: Long
)

package br.com.vitor.forum.dto.form

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicForm (
   @field:NotEmpty(message = "Title cannot be blank") @field:Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters long") val title: String,
   @field:NotEmpty(message = "Message cannot be blank") val message: String,
   @field:NotNull  val idCurse: Long,
   @field:NotNull  val idAuthor: Long
)

package br.com.vitor.forum.dto.form

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicForm (
   @field:NotEmpty @field:Size(min = 5, max = 100) val title: String,
   @field:NotEmpty val message: String,
   @field:NotNull  val idCurse: Long,
   @field:NotNull  val idAuthor: Long
)

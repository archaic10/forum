package br.com.vitor.forum.dto.view
import br.com.vitor.forum.model.StatusTopic
import java.time.LocalDateTime

data class TopicView (
    val id:Long?,
    val title:String,
    val message:String,
    val status: StatusTopic,
    val dateCreated: LocalDateTime,
)
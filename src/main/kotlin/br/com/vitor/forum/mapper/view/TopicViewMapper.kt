package br.com.vitor.forum.mapper.view

import br.com.vitor.forum.dto.view.TopicView
import br.com.vitor.forum.mapper.Mapper
import br.com.vitor.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return  TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            dateCreated = t.dateCreated,
            status = t.status
        )
    }
}
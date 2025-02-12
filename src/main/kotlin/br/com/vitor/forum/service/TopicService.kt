package br.com.vitor.forum.service

import br.com.vitor.forum.dto.form.TopicForm
import br.com.vitor.forum.dto.form.UpdateTopicForm
import br.com.vitor.forum.dto.view.TopicView
import br.com.vitor.forum.mapper.view.TopicViewMapper
import br.com.vitor.forum.mapper.form.TopicFormMapper
import br.com.vitor.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val curseService: CurseService,
) {


    fun list(): List<TopicView> {
        return topics.stream().map{ t -> topicViewMapper.map(t)}.collect(Collectors.toList());
    }

    fun searchById(id: Long): TopicView {
        val topic = topics.stream().filter{ t ->
            t.id == id
        }.findFirst().get();

        return topicViewMapper.map(topic)
    }

    fun register(dto: TopicForm): TopicView {
        val topic = topicFormMapper.map(dto)
        topic.id = topics.size.toLong() +1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(dto: UpdateTopicForm):TopicView {
        val topic = topics.stream().filter{ t ->
            t.id == dto.id
        }.findFirst().get()

        val topicUpdated = Topic(
            id = dto.id,
            title = dto.title,
            message = dto.message,
            author = topic.author,
            curse = topic.curse,
            response = topic.response,
            status = topic.status,
            dateCreated = topic.dateCreated
        )
        topics = topics.minus(topic).plus(topicUpdated)
        return topicViewMapper.map(topicUpdated)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter{ t ->
            t.id == id
        }.findFirst().get()
        topics = topics.minus(topic)
    }
}
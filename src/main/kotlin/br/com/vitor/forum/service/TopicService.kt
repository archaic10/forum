package br.com.vitor.forum.service

import br.com.vitor.forum.dto.form.TopicForm
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
) {


    fun list(): List<TopicView> {
        return topics.stream().map{ t -> topicViewMapper.map(t)}.collect(Collectors.toList());
    }

    fun searchById(id: Long): TopicView {
        val topic = topics.stream().filter({ t ->
            t.id == id
        }).findFirst().get();

        return topicViewMapper.map(topic)
    }

    fun register(dto: TopicForm) {
        val topic = topicFormMapper.map(dto)
        topic.id = topics.size.toLong() +1
        topics = topics.plus(topic);
    }
}
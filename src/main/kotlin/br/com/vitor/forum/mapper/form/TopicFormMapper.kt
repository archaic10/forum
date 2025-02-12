package br.com.vitor.forum.mapper.form

import br.com.vitor.forum.dto.form.TopicForm
import br.com.vitor.forum.mapper.Mapper
import br.com.vitor.forum.model.Topic
import br.com.vitor.forum.service.CurseService
import br.com.vitor.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper (private val curseService: CurseService,
                       private val userService: UserService): Mapper<TopicForm, Topic>  {

    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            curse = curseService.searchById(t.idCurse),
            author = userService.searchById(t.idAuthor)
        )
    }

}

package br.com.vitor.forum.controller

import br.com.vitor.forum.dto.form.TopicForm
import br.com.vitor.forum.dto.view.TopicView
import br.com.vitor.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController (private val service: TopicService) {
    @GetMapping
    fun list(): List<TopicView> {
       return service.list();
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id:Long):TopicView {
        return service.searchById(id);
    }

    @PostMapping
    fun register(@RequestBody @Valid dto: TopicForm) {
        service.register(dto);
    }

}
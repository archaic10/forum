package br.com.vitor.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForumApplication

fun main(args: Array<String>) {
	runApplication<ForumApplication>(*args)
}

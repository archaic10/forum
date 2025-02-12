package br.com.vitor.forum.service

import br.com.vitor.forum.model.Curse
import org.springframework.stereotype.Service
import java.util.*

@Service
class CurseService (var curses:List<Curse>) {

    init {
        val curse = Curse(
            id = 1,
            name = "Kotlin",
            category = "Programming",
        )
        curses = Arrays.asList(curse)
    }

    fun searchById(id:Long):Curse {
        return curses.stream().filter({c -> c.id == id}).findFirst().get()
    }
}

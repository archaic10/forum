package br.com.vitor.forum.service

import br.com.vitor.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (var users:List<User>){
    init {
        val user = User(
            id = 1,
            name = "Vitor",
            email = "vitor@vitor.de",
        )
        users = Arrays.asList(user)
    }

    fun searchById(id:Long):User {
        return users.stream().filter({u -> u.id == id}).findFirst().get()
    }
}

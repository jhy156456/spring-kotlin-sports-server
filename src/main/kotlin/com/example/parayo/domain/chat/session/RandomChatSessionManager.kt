package com.example.parayo.domain.chat.session

import com.example.parayo.domain.user.User
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class RandomChatSessionManager {

    private val sessions =
        ConcurrentHashMap<User, RandomChatSession>()

    fun addSession(user: User, session: RandomChatSession) {
        sessions[user] = session
    }

    fun removeSession(user: User) {
        sessions[user]?.close()
        sessions.remove(user)
    }

    fun getSession(user: User): RandomChatSession? {
        return sessions[user]
    }

}

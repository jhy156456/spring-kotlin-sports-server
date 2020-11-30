package com.example.parayo.domain.chat.room

import com.example.parayo.domain.user.User
import java.util.concurrent.atomic.AtomicLong

class RandomChatRoom private constructor(
    val id: Long
) {

    val users = mutableListOf<User>()

    fun addUser(user: User) {
        synchronized(users) {
            users.add(user)
        }
    }

    fun removeUser(user: User) {
        synchronized(users) {
            users.remove(user)
        }
    }

    companion object {
        private val nextRoomId = AtomicLong(1)

        fun create(): RandomChatRoom {
            val roomId = nextRoomId.getAndIncrement()
            return RandomChatRoom(roomId)
        }
    }

}

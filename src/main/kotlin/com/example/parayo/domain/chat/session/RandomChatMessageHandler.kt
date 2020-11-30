package com.example.parayo.domain.chat.session

import com.example.parayo.domain.chat.room.RandomChatRoomManager
import com.example.parayo.domain.user.User
import org.springframework.stereotype.Component

@Component
class RandomChatMessageHandler(
        private val randomChatRoomManager: RandomChatRoomManager,
        private val randomChatSessionManager: RandomChatSessionManager
) {

    fun onMessage(sender: User, message: String) {
        val room = randomChatRoomManager.findRoomByUser(sender)

        room?.let {
            val chatMessage = ChatMessage(sender.nickName, message)

            room.users
                .filter { user ->
                    user.id != sender.id
                }
                .forEach { user ->
                    val session = randomChatSessionManager.getSession(user)
                    session?.sendMessage(chatMessage)
                }
        }
    }

}
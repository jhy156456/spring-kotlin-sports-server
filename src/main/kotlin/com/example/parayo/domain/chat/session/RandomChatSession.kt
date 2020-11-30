package com.example.parayo.domain.chat.session

import com.example.parayo.domain.chat.session.ChatMessage

interface RandomChatSession {

    fun isOpen(): Boolean

    fun close()

    fun sendMessage(message: ChatMessage)

}
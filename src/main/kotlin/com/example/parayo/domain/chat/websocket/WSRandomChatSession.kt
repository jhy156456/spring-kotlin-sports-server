package com.example.parayo.domain.chat.websocket

import com.example.parayo.domain.chat.session.ChatMessage
import com.example.parayo.domain.chat.session.RandomChatSession
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession

class WSRandomChatSession(
    private val webSocketSession: WebSocketSession
) : RandomChatSession {

    override fun isOpen(): Boolean {
        return webSocketSession.isOpen
    }

    override fun close() {
        webSocketSession.close(CloseStatus.NORMAL)
    }

    override fun sendMessage(message: ChatMessage) {
        val jsonMessage = ObjectMapper()
            .writeValueAsString(message)
        val webSocketTextMessage = TextMessage(jsonMessage)

        webSocketSession.sendMessage(webSocketTextMessage)
    }

}
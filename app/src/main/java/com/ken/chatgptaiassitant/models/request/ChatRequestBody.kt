package com.ken.chatgptaiassitant.models.request

data class ChatRequestBody(
    val messages: List<Message>,
    val model: String
)
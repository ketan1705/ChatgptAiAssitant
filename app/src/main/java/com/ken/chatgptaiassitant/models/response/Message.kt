package com.ken.chatgptaiassitant.models.response

data class Message(
    val content: String,
    val refusal: Any,
    val role: String
)
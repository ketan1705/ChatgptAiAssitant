package com.ken.chatgptaiassitant.models.response

data class Choice(
    val finish_reason: String,
    val index: Int,
    val logprobs: Any,
    val message: Message
)
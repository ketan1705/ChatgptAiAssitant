package com.ken.chatgptaiassitant.models.response

data class CompletionTokensDetails(
    val accepted_prediction_tokens: Int,
    val audio_tokens: Int,
    val reasoning_tokens: Int,
    val rejected_prediction_tokens: Int
)
package com.ken.chatgptaiassitant.models.response

data class Usage(
    val completion_tokens: Int,
    val completion_tokens_details: CompletionTokensDetails,
    val prompt_tokens: Int,
    val prompt_tokens_details: PromptTokensDetails,
    val total_tokens: Int
)
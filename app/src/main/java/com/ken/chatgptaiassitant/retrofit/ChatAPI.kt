package com.ken.chatgptaiassitant.retrofit

import com.ken.chatgptaiassitant.models.request.ChatRequestBody
import com.ken.chatgptaiassitant.models.response.ChatResponse
import com.ken.chatgptaiassitant.utils.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChatAPI {
    @Headers(
        "Content-Type:application/json",
        "Authorization: Bearer $API_KEY",
        "OpenAI-Organization:org-Gg59PCFBJ1wtcfxNBUfNmKAo",
        "OpenAI-Project:proj_D6DxKw0VFG1TwBXfNCRKN3OO"
    )
    @POST("/v1/chat/completions")
    suspend fun getChatResponse(
        @Body requestBody: ChatRequestBody,
    ): Response<ChatResponse>

}
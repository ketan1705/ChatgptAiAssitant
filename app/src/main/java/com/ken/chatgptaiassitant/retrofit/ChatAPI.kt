package com.ken.chatgptaiassitant.retrofit

import com.ken.chatgptaiassitant.models.request.ChatRequestBody
import com.ken.chatgptaiassitant.models.response.ChatResponse
import com.ken.chatgptaiassitant.utils.Constant.API_KEY
import com.ken.chatgptaiassitant.utils.Constant.ORG_ID
import com.ken.chatgptaiassitant.utils.Constant.PROJECT_ID
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChatAPI {
    @Headers(
        "Content-Type:application/json",
        "Authorization: Bearer $API_KEY",
        "OpenAI-Organization:$ORG_ID",
        "OpenAI-Project:$PROJECT_ID"
    )
    @POST("/v1/chat/completions")
    suspend fun getChatResponse(
        @Body requestBody: ChatRequestBody,
    ): Response<ChatResponse>

}
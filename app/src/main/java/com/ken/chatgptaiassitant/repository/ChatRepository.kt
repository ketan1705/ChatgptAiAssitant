package com.ken.chatgptaiassitant.repository

import com.ken.chatgptaiassitant.models.request.ChatRequestBody
import com.ken.chatgptaiassitant.retrofit.ChatAPI
import javax.inject.Inject


class ChatRepository @Inject constructor(private val chatAPI: ChatAPI) {


    /* suspend fun loadMessage(): List<String> {
         TODO("Not yet implemented")
     }
 */
    suspend fun sendMessage(requestBody: ChatRequestBody): String? {
        val response = chatAPI.getChatResponse(requestBody)
        if (response.isSuccessful && response.body() != null) {

            return response.body()!!.choices[0].message.content
        }
        return null
    }
}
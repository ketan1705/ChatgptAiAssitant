package com.ken.chatgptaiassitant.repository

import android.util.Log
import com.ken.chatgptaiassitant.models.request.ChatRequestBody
import com.ken.chatgptaiassitant.retrofit.ChatAPI
import com.ken.chatgptaiassitant.utils.Constant.TAG
import javax.inject.Inject


class ChatRepository @Inject constructor(private val chatAPI: ChatAPI) {


    /* suspend fun loadMessage(): List<String> {
         TODO("Not yet implemented")
     }
 */
    suspend fun sendMessage(requestBody: ChatRequestBody): String? {
        val response = chatAPI.getChatResponse(requestBody)
        return if (response.isSuccessful && response.body() != null) {
            Log.d(TAG, "sendMessage Success ")
            response.body()!!.choices[0].message.content
        } else {
            Log.d(TAG, "sendMessage Failed ")
            null
        }
    }
}
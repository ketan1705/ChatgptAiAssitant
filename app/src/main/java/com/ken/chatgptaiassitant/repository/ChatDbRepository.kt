package com.ken.chatgptaiassitant.repository

import com.ken.chatgptaiassitant.database.ChatDao
import com.ken.chatgptaiassitant.models.Chat
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatDbRepository @Inject constructor(
    val chatDao: ChatDao,
) {

    suspend fun insertChat(chat: Chat) {
        chatDao.insertChat(chat)
    }

    suspend fun getChats(chatId: String): Chat? {
        return chatDao.getChatById(chatId)
    }

    fun getAllChats(): Flow<List<Chat>> {
        return chatDao.getAllChats()
    }

    suspend fun deleteChat(chatId: String) {
        chatDao.deleteChatById(chatId)
    }

}

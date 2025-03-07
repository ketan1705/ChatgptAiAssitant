package com.ken.chatgptaiassitant.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ken.chatgptaiassitant.models.Chat
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChat(chat: Chat)

    @Query("Select * From chats")
    fun getAllChats(): Flow<List<Chat>>

    @Query("Select * From chats Where chat_id = :id")
    suspend fun getChatById(id: String): Chat?

    @Query("Select * From chats Where chat_id = :id")
    suspend fun deleteChatById(id: String): Chat

}
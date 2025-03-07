package com.ken.chatgptaiassitant.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ken.chatgptaiassitant.models.Chat
import com.ken.chatgptaiassitant.utils.Converters

@Database(entities = [Chat::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ChatGptDatabase : RoomDatabase() {

    abstract fun chatDao(): ChatDao

}
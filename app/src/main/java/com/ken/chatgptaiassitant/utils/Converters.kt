package com.ken.chatgptaiassitant.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ken.chatgptaiassitant.models.ChatModel

class Converters {

    @TypeConverter
    fun fromChatModelList(value: List<ChatModel>?): String {
        val gson = Gson()
        val type = object : TypeToken<List<ChatModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toChatModelList(value: String): List<ChatModel> {
        val gson = Gson()
        val type = object : TypeToken<List<ChatModel>>() {}.type
        return gson.fromJson(value, type)
    }

}
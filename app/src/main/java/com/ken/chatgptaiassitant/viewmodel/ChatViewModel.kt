package com.ken.chatgptaiassitant.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.ken.chatgptaiassitant.models.Chat
import com.ken.chatgptaiassitant.models.ChatModel
import com.ken.chatgptaiassitant.models.enums.CHATGPTMODEL
import com.ken.chatgptaiassitant.models.enums.ChatRole
import com.ken.chatgptaiassitant.models.request.ChatRequestBody
import com.ken.chatgptaiassitant.models.request.Message
import com.ken.chatgptaiassitant.repository.ChatDbRepository
import com.ken.chatgptaiassitant.repository.ChatRepository
import com.ken.chatgptaiassitant.repository.FirebaseRepository
import com.ken.chatgptaiassitant.utils.Constant
import com.ken.chatgptaiassitant.utils.Constant.TAG
import com.ken.chatgptaiassitant.utils.Converters
import com.ken.chatgptaiassitant.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
    private val firebaseRepository: FirebaseRepository,
    private val chatDbRepository: ChatDbRepository,
) : ViewModel() {

    private val _messages = MutableStateFlow<List<ChatModel>>(emptyList())
    val messages: StateFlow<List<ChatModel>>
        get() = _messages
    private val _allChats = MutableStateFlow<List<Chat>>(emptyList())
    val allChats: StateFlow<List<Chat>>
        get() = _allChats
    private val _networkResult = MutableStateFlow<NetworkResult<String>?>(null)
    val networkResult: StateFlow<NetworkResult<String>?>
        get() = _networkResult

    init {
        getAllChats()
        loadMessages()

    }

    fun sendMessage(message: String) {
        viewModelScope.launch {
            _networkResult.value = NetworkResult.Loading()
            _messages.value = _messages.value + (ChatModel(message, ChatRole.USER.role))
            saveMessage(ChatModel(message, ChatRole.USER.role))
            val requestBody = requestBody(message)
            try {
                val message = chatRepository.sendMessage(requestBody)
                message?.let {
                    _messages.value = _messages.value + (ChatModel(message, ChatRole.AIMODEL.role))
                    saveMessage(ChatModel(message, ChatRole.AIMODEL.role))
                }
                _networkResult.value = NetworkResult.Success(message!!)
            } catch (e: Exception) {
                _networkResult.value = NetworkResult.Error(e)
            }
        }
    }

    fun loadMessages() {
        viewModelScope.launch {
            val chats = chatDbRepository.getChats("1")
            chats?.let {
                val chatModel = Converters().toChatModelList(it.chatMessage)
                _messages.value = _messages.value + chatModel
            }
            Log.d(TAG, "Messages: ${_messages.value}")
        }
    }

    fun getAllChats() {
        viewModelScope.launch {
            val allChats = chatDbRepository.getAllChats()
            allChats.let {
                it.collect { chatList ->
                    _allChats.value = chatList
                    Log.d(TAG, "getAllChats: $chatList")
                }
            }
            Log.d(TAG, "All Chats: ${_allChats.value}")
        }
    }


    fun saveMessage(chatModel: ChatModel) {
        viewModelScope.launch {
            val updatedMessage = messages.value
            val chat = Chat("1", chatMessage = Gson().toJson(updatedMessage))
            chatDbRepository.insertChat(chat = chat)
            val chats = chatDbRepository.getChats("1")
            Log.d(
                Constant.TAG,
                "saveMessage: ${Converters().toChatModelList(chats?.chatMessage.toString())}"
            )
            firebaseRepository.saveMessage(chatModel)
        }
    }


    fun requestBody(message: String): ChatRequestBody {
        return ChatRequestBody(
            model = CHATGPTMODEL.GPT4oMINI.model,
            messages = listOf(
                Message(
                    role = ChatRole.USER.role, content = message
                )
            )
        )
    }
}
package com.ken.chatgptaiassitant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ken.chatgptaiassitant.models.CHATGPTMODEL
import com.ken.chatgptaiassitant.models.ChatModel
import com.ken.chatgptaiassitant.models.ChatRole
import com.ken.chatgptaiassitant.models.request.ChatRequestBody
import com.ken.chatgptaiassitant.models.request.Message
import com.ken.chatgptaiassitant.repository.ChatRepository
import com.ken.chatgptaiassitant.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val chatRepository: ChatRepository) : ViewModel() {

    private val _messages = MutableStateFlow<List<ChatModel>>(emptyList())
    val messages: StateFlow<List<ChatModel>>
        get() = _messages
    private val _networkResult = MutableStateFlow<NetworkResult<String>?>(null)
    val networkResult: StateFlow<NetworkResult<String>?>
        get() = _networkResult

    fun sendMessage(message: String) {
        viewModelScope.launch {
            _networkResult.value = NetworkResult.Loading()
            try {
                _messages.value = _messages.value + (ChatModel(message, ChatRole.USER.role))
                val requestBody = requestBody(message)
                val message = chatRepository.sendMessage(requestBody)
                message?.let {
                    _messages.value = _messages.value + (ChatModel(message, ChatRole.AIMODEL.role))
                }
                _networkResult.value = NetworkResult.Success(message!!)
            } catch (e: Exception) {
                _networkResult.value = NetworkResult.Error(e)
            }
        }
    }

    fun requestBody(message: String): ChatRequestBody {
        return ChatRequestBody(
            model = CHATGPTMODEL.GPT35TURBO.model,
            messages = listOf(
                Message(
                    role = ChatRole.USER.role, content = message
                )
            )
        )
    }
}
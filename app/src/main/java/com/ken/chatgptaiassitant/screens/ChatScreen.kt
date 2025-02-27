package com.ken.chatgptaiassitant.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ken.chatgptaiassitant.components.ScreenBg
import com.ken.chatgptaiassitant.components.chat.ChatFooter
import com.ken.chatgptaiassitant.components.chat.ChatList
import com.ken.chatgptaiassitant.viewmodel.ChatViewModel

@Composable
fun ChatScreen() {

    val chatViewModel: ChatViewModel = hiltViewModel()
    val messages = chatViewModel.messages.collectAsState()
    val networkResult = chatViewModel.networkResult.collectAsState().value
//    var count = remember { mutableIntStateOf(0) }

    /*  LaunchedEffect(Unit) {
          chatViewModel.sendMessage("hello")
      }
      if (networkResult is NetworkResult.Success)
          Log.d(TAG, "ChatScreen: ${messages.value}")
      OutlinedButton(onClick = {
          when (count.intValue) {
              0 -> {
                  chatViewModel.sendMessage("How are you?")
              }

              1 -> {
                  chatViewModel.sendMessage("What is android?")
              }

              2 -> {
                  chatViewModel.sendMessage("What is hilt?")
              }

              else -> {
                  count.intValue = 0
              }
          }
          count.intValue++
          Log.d(TAG, "ChatScreen: ${messages.value}")
      }) {
          Text(
              text = "Send Message",
              style = MaterialTheme.typography.labelMedium,
              fontSize = 18.sp,
              color = Color.Black
          )
      }
  */
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = ScreenBg()
            )
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChatList(list = messages.value)
        }
        ChatFooter {
            if (it.isNotEmpty()) {
                // send input to gemini
                chatViewModel.sendMessage(it)
            }
        }
    }


}
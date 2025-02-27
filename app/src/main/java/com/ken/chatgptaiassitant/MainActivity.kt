package com.ken.chatgptaiassitant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ken.chatgptaiassitant.components.ScreenBg
import com.ken.chatgptaiassitant.navigation.NavGraph
import com.ken.chatgptaiassitant.ui.theme.ChatgptAiAssitantTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatgptAiAssitantTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("ChatGPT AI Assistant")
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFF2be4dc)
                            )
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(ScreenBg())
                    )
                    {
                        NavGraph()
                    }
                }
            }
        }
    }
}
/*

fun requestBody(): ChatRequestBody {
    return ChatRequestBody(
        model = "gpt-4o-mini",
        messages = listOf(
            Message(
                role = ChatRole.USER.role, content = "I am good what about you"
            )
        )
    )
}

fun sendMessage(chatAPI: ChatAPI) {
    val chatRequestBody = requestBody()
    CoroutineScope(Dispatchers.IO).launch {
        var response = chatAPI.getChatResponse(chatRequestBody)
        if (response.isSuccessful && response.body() != null) {
//                val result = response.body()!!.choices[0].message.content
            val resultList = response.body()!!.choices.map {
                it.message.content
            }
            Log.d(TAG, "ChatGpt Model Response: $resultList")
        }
    }
}*/

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
import com.ken.chatgptaiassitant.components.ScreenBg
import com.ken.chatgptaiassitant.navigation.NavGraph
import com.ken.chatgptaiassitant.ui.theme.ChatgptAiAssitantTheme
import com.ken.chatgptaiassitant.ui.theme.lightBlue
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
                                containerColor = lightBlue
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

package com.ken.chatgptaiassitant.components.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.chatgptaiassitant.models.ChatModel
import com.ken.chatgptaiassitant.models.ChatRole
import com.ken.chatgptaiassitant.ui.theme.PurpleGrey80

@Composable
fun ChatList(list: List<ChatModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(list)
        {
            ChatBox(it)
        }
    }
}

@Composable
fun ChatBox(items: ChatModel) {
    val alignment = if (items.role == ChatRole.USER.role) Alignment.End else Alignment.Start
    val backgroundColor =
        if (items.role == ChatRole.USER.role) MaterialTheme.colorScheme.primary else Color.Gray
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {

        Box(
            modifier = Modifier
                .align(alignment = alignment)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = if (items.role == ChatRole.USER.role) 30.dp else 20.dp,
                        topEnd = if (items.role == ChatRole.USER.role) 20.dp else 30.dp,
                        bottomStart = if (items.role == ChatRole.USER.role) 30.dp else 0.dp,
                        bottomEnd = if (items.role == ChatRole.USER.role) 0.dp else 30.dp,
                    )
                )
                .background(PurpleGrey80)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        )
        {
            Text(
                text = items.message,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}
package com.ken.chatgptaiassitant.components.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatFooter(
    onClick: (text: String) -> Unit,
) {
    var inputText by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
    {
        TextField(
            value = inputText, onValueChange = { inputText = it },
            placeholder = {
                Text(
                    text = "Type a message",
                    color = Color.Black,
                    style = TextStyle(fontSize = 16.sp)
                )
            },
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Cyan.copy(0.6f),
                unfocusedContainerColor = Color.Cyan.copy(0.6f),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )

        IconButton(onClick = {
            onClick(inputText)
            inputText = ""
        })
        {
            Icon(
                Icons.AutoMirrored.Rounded.Send, contentDescription = "Send", tint = Color.Black,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Cyan.copy(0.6f))
                    .padding(8.dp)
            )
        }
    }
}
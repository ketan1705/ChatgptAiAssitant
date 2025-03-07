package com.ken.chatgptaiassitant.components.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.chatgptaiassitant.ui.theme.lightBlue

@Composable
fun ChatFooter(
    modifier: Modifier,
    onClick: (text: String) -> Unit,
) {
    var inputText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
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
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp),
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = lightBlue.copy(0.9f),
                unfocusedContainerColor = lightBlue.copy(0.9f),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    if (inputText.isNotBlank()) {
                        onClick(inputText.trim().toString())
                        inputText = ""
                        keyboardController?.hide()
                    }
                }
            )
        )
        IconButton(onClick = {
            onClick(inputText.trim().toString())
            inputText = ""
            keyboardController?.hide()
        })
        {
            Icon(
                Icons.AutoMirrored.Rounded.Send, contentDescription = "Send", tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(lightBlue.copy(0.9f))
                    .padding(8.dp)
            )
        }
    }
}
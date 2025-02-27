package com.ken.chatgptaiassitant.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "ChatGpt AI Assistant",
        fontSize = 20.sp,
        color = Color.Black,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        modifier = modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .padding(top = 50.dp, bottom = 10.dp)
    )

}
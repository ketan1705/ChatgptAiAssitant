package com.ken.chatgptaiassitant.components

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun ScreenBg(): Brush {
    return Brush.Companion.linearGradient(
        listOf(Color(0xFF2be4dc),
            Color(0xFF243484))
    )
}